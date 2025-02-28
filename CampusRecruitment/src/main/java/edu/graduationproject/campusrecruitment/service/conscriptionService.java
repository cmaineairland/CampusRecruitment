package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.conscription;
import edu.graduationproject.campusrecruitment.pojo.DTO.conscriptionDTO;
import edu.graduationproject.campusrecruitment.repository.IConscriptionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class conscriptionService implements IConscriptionService {

    @Autowired
    private IConscriptionRepository conscriptionRepository;

    @Override
    public conscription add(conscriptionDTO conscriptionDTO) {
        conscription conscription = new conscription();
        BeanUtils.copyProperties(conscriptionDTO, conscription);
        return conscriptionRepository.save(conscription);
    }

    @Override
    public boolean delete(int conscriptionId) {
        Optional<conscription> conscriptionOptional = conscriptionRepository.findById(conscriptionId);
        if (conscriptionOptional.isPresent()) {
            conscriptionRepository.delete(conscriptionOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<conscription> update(int conscriptionId, conscriptionDTO conscriptionDTO) {
        Optional<conscription> conscriptionOptional = conscriptionRepository.findById(conscriptionId);
        if (conscriptionOptional.isPresent()) {
            conscription existingConscription = conscriptionOptional.get();
            BeanUtils.copyProperties(conscriptionDTO, existingConscription, "conscriptionId");
            return Optional.of(conscriptionRepository.save(existingConscription));
        }
        return Optional.empty();
    }

    @Override
    public Optional<conscription> getById(int conscriptionId) {
        return conscriptionRepository.findById(conscriptionId);
    }

    @Override
    public List<conscription> getAll() {
        return conscriptionRepository.findAll();
    }

    @Override
    public List<conscription> getByStudentId(int studentId) {
        return conscriptionRepository.findByStudentId(studentId);
    }

    @Override
    public List<conscription> getByAdminId(int adminId) {
        return conscriptionRepository.findByAdminId(adminId);
    }
}