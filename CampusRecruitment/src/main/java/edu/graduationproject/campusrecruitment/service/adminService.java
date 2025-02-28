package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.adminDTO;
import edu.graduationproject.campusrecruitment.pojo.admin;
import edu.graduationproject.campusrecruitment.repository.IAdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class adminService implements IAdminService {

    @Autowired
    IAdminRepository adminRepository;

    @Override
    public admin add(adminDTO adminDTO) {
        admin adminPojo = new admin();
        // 将 DTO 转换为实体类
        BeanUtils.copyProperties(adminDTO, adminPojo);
        return adminRepository.save(adminPojo);
    }

    @Override
    public boolean delete(int adminId) {
        Optional<admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            adminRepository.delete(adminOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<admin> update(int adminId, adminDTO adminDTO) {
        Optional<admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            admin existingAdmin = adminOptional.get();
            // 更新现有管理员对象的属性
            BeanUtils.copyProperties(adminDTO, existingAdmin, "adminId"); // 排除 adminId 不被覆盖
            return Optional.of(adminRepository.save(existingAdmin));
        }
        return Optional.empty();
    }

    @Override
    public Optional<admin> getById(int adminId) {
        return adminRepository.findById(adminId);
    }

    @Override
    public List<admin> getAll() {
        Iterable<admin> adminsIterable = adminRepository.findAll();
        return (List<admin>) adminsIterable;  // 方法 1: 直接转换
        // 或者使用 stream 转换为 List
        // return StreamSupport.stream(adminsIterable.spliterator(), false)
        //        .collect(Collectors.toList());  // 方法 2: 使用 Stream
    }
}