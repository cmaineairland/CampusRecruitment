package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.retiredDTO;
import edu.graduationproject.campusrecruitment.pojo.retired;
import edu.graduationproject.campusrecruitment.repository.IRetiredRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class retiredService implements IRetiredService {

    @Autowired
    private IRetiredRepository retiredRepository;

    @Override
    public retired add(retiredDTO retiredDTO) {
        retired retiredEntity = new retired();
        BeanUtils.copyProperties(retiredDTO, retiredEntity);
        return retiredRepository.save(retiredEntity);
    }

    @Override
    public boolean delete(int retiredId) {
        Optional<retired> retiredOptional = retiredRepository.findById(retiredId);
        if (retiredOptional.isPresent()) {
            retiredRepository.delete(retiredOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<retired> update(int retiredId, retiredDTO retiredDTO) {
        Optional<retired> retiredOptional = retiredRepository.findById(retiredId);
        if (retiredOptional.isPresent()) {
            retired existingRetired = retiredOptional.get();
            BeanUtils.copyProperties(retiredDTO, existingRetired, "retiredId");
            return Optional.of(retiredRepository.save(existingRetired));
        }
        return Optional.empty();
    }

    @Override
    public Optional<retired> getById(int retiredId) {
        return retiredRepository.findById(retiredId);
    }

    @Override
    public List<retired> getAll() {
        return retiredRepository.findAll();
    }

    @Override
    public List<retired> getByStudentId(int studentId) {
        return retiredRepository.findByStudentId(studentId);
    }

    @Override
    public List<retired> getByAdminId(int adminId) {
        return retiredRepository.findByAdminId(adminId);
    }
}