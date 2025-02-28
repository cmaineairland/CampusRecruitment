package edu.graduationproject.campusrecruitment.controller;

import edu.graduationproject.campusrecruitment.pojo.DTO.retiredDTO;
import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import edu.graduationproject.campusrecruitment.pojo.retired;
import edu.graduationproject.campusrecruitment.service.IRetiredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/retired")
public class retiredController {

    @Autowired
    private IRetiredService retiredService;

    // 添加退役复学信息
    @PostMapping
    public responseMessage<retired> addRetired(@Validated @RequestBody retiredDTO retiredDTO) {
        retired newRetired = retiredService.add(retiredDTO);
        return responseMessage.success(newRetired);
    }

    // 删除退役复学信息
    @DeleteMapping("/{retiredId}")
    public responseMessage<String> deleteRetired(@PathVariable int retiredId) {
        boolean isDeleted = retiredService.delete(retiredId);
        if (isDeleted) {
            return responseMessage.success("Retired information with ID " + retiredId + " deleted successfully.");
        } else {
            return responseMessage.error("Retired information with ID " + retiredId + " not found.");
        }
    }

    // 更新退役复学信息
    @PutMapping("/{retiredId}")
    public responseMessage<retired> updateRetired(@PathVariable int retiredId, @Validated @RequestBody retiredDTO retiredDTO) {
        Optional<retired> updatedRetired = retiredService.update(retiredId, retiredDTO);
        if (updatedRetired.isPresent()) {
            return responseMessage.success(updatedRetired.get());
        } else {
            return responseMessage.error("Retired information with ID " + retiredId + " not found.");
        }
    }

    // 根据 ID 获取退役复学信息
    @GetMapping("/{retiredId}")
    public responseMessage<retired> getRetiredById(@PathVariable int retiredId) {
        Optional<retired> retiredOptional = retiredService.getById(retiredId);
        return retiredOptional
                .map(responseMessage::success)
                .orElseGet(() -> responseMessage.error("Retired information with ID " + retiredId + " not found."));
    }

    // 获取所有退役复学信息
    @GetMapping
    public responseMessage<List<retired>> getAllRetired() {
        List<retired> retireds = retiredService.getAll();
        return responseMessage.success(retireds);
    }

    // 根据学生 ID 获取退役复学信息
    @GetMapping("/student/{studentId}")
    public responseMessage<List<retired>> getRetiredByStudentId(@PathVariable int studentId) {
        List<retired> retireds = retiredService.getByStudentId(studentId);
        return responseMessage.success(retireds);
    }

    // 根据管理员 ID 获取退役复学信息
    @GetMapping("/admin/{adminId}")
    public responseMessage<List<retired>> getRetiredByAdminId(@PathVariable int adminId) {
        List<retired> retireds = retiredService.getByAdminId(adminId);
        return responseMessage.success(retireds);
    }
}