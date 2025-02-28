package edu.graduationproject.campusrecruitment.controller;

import edu.graduationproject.campusrecruitment.pojo.DTO.adminDTO;
import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import edu.graduationproject.campusrecruitment.pojo.admin;
import edu.graduationproject.campusrecruitment.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    IAdminService adminService;

    // add an admin
    @PostMapping
    public responseMessage<admin> addAdmin(@Validated @RequestBody adminDTO adminDTO) {
        admin newAdmin = adminService.add(adminDTO);
        return responseMessage.success(newAdmin);
    }

    // delete admin
    @DeleteMapping("/{adminId}")
    public responseMessage<String> deleteAdmin(@PathVariable int adminId) {
        boolean isDeleted = adminService.delete(adminId);
        if (isDeleted) {
            return responseMessage.success("Admin with ID " + adminId + " deleted successfully.");
        } else {
            return responseMessage.error("Admin with ID " + adminId + " not found.");
        }
    }

    // update admin
    @PutMapping("/{adminId}")
    public responseMessage<admin> updateAdmin(@PathVariable int adminId, @Validated @RequestBody adminDTO adminDTO) {
        Optional<admin> updatedAdmin = adminService.update(adminId, adminDTO);
        if (updatedAdmin.isPresent()) {
            return responseMessage.success(updatedAdmin.get());
        } else {
            return responseMessage.error("Admin with ID " + adminId + " not found.");
        }
    }

    // select admin by id
    @GetMapping("/{adminId}")
    public responseMessage<admin> getAdminById(@PathVariable int adminId) {
        Optional<admin> adminOptional = adminService.getById(adminId);
        return adminOptional
                .map(responseMessage::success)
                .orElseGet(() -> responseMessage.error("Admin with ID " + adminId + " not found."));
    }

    // select all admins
    @GetMapping()
    public responseMessage<List<admin>> getAllAdmins() {
        List<admin> admins = adminService.getAll();
        return responseMessage.success(admins);
    }
}