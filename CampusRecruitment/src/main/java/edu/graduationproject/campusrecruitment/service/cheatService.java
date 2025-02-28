package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.cheatDTO;
import edu.graduationproject.campusrecruitment.pojo.cheat;
import edu.graduationproject.campusrecruitment.repository.ICheatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cheatService implements ICheatService {

    @Autowired
    ICheatRepository cheatRepository;

    @Override
    public cheat add(cheatDTO cheatDTO) {
        cheat cheatPojo = new cheat();
        // 将 DTO 转换为实体类
        BeanUtils.copyProperties(cheatDTO, cheatPojo);
        return cheatRepository.save(cheatPojo);
    }

    @Override
    public boolean delete(int senId) {
        Optional<cheat> cheatOptional = cheatRepository.findById(senId);
        if (cheatOptional.isPresent()) {
            cheatRepository.delete(cheatOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<cheat> update(int senId, cheatDTO cheatDTO) {
        Optional<cheat> cheatOptional = cheatRepository.findById(senId);
        if (cheatOptional.isPresent()) {
            cheat existingCheat = cheatOptional.get();
            // 更新现有对象的属性
            BeanUtils.copyProperties(cheatDTO, existingCheat, "senId"); // 排除 senId 不被覆盖
            return Optional.of(cheatRepository.save(existingCheat));
        }
        return Optional.empty();
    }

    @Override
    public Optional<cheat> getById(int senId) {
        return cheatRepository.findById(senId);
    }

    @Override
    public List<cheat> getAll() {
        Iterable<cheat> cheatsIterable = cheatRepository.findAll();
        return (List<cheat>) cheatsIterable;  // 方法 1: 直接转换
        // 或者使用 stream 转换为 List
        // return StreamSupport.stream(cheatsIterable.spliterator(), false)
        //        .collect(Collectors.toList());  // 方法 2: 使用 Stream
    }
}