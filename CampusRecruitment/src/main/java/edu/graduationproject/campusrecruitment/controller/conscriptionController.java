package edu.graduationproject.campusrecruitment.controller;

import edu.graduationproject.campusrecruitment.pojo.DTO.conscriptionDTO;
import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import edu.graduationproject.campusrecruitment.pojo.conscription;
import edu.graduationproject.campusrecruitment.service.IConscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conscription")
public class conscriptionController {

    @Autowired
    private IConscriptionService conscriptionService;

    // 添加征兵信息
    @PostMapping
    public responseMessage<conscription> addConscription(@Validated @RequestBody conscriptionDTO conscriptionDTO) {
        conscription newConscription = conscriptionService.add(conscriptionDTO);
        return responseMessage.success(newConscription);
    }

    // 删除征兵信息
    @DeleteMapping("/{conscriptionId}")
    public responseMessage<String> deleteConscription(@PathVariable int conscriptionId) {
        boolean isDeleted = conscriptionService.delete(conscriptionId);
        if (isDeleted) {
            return responseMessage.success("Conscription with ID " + conscriptionId + " deleted successfully.");
        } else {
            return responseMessage.error("Conscription with ID " + conscriptionId + " not found.");
        }
    }

    // 更新征兵信息
    @PutMapping("/{conscriptionId}")
    public responseMessage<conscription> updateConscription(@PathVariable int conscriptionId, @Validated @RequestBody conscriptionDTO conscriptionDTO) {
        Optional<conscription> updatedConscription = conscriptionService.update(conscriptionId, conscriptionDTO);
        if (updatedConscription.isPresent()) {
            return responseMessage.success(updatedConscription.get());
        } else {
            return responseMessage.error("Conscription with ID " + conscriptionId + " not found.");
        }
    }

    // 根据 ID 获取征兵信息
    @GetMapping("/{conscriptionId}")
    public responseMessage<conscription> getConscriptionById(@PathVariable int conscriptionId) {
        Optional<conscription> conscriptionOptional = conscriptionService.getById(conscriptionId);
        return conscriptionOptional
                .map(responseMessage::success)
                .orElseGet(() -> responseMessage.error("Conscription with ID " + conscriptionId + " not found."));
    }

    // 获取所有征兵信息
    @GetMapping
    public responseMessage<List<conscription>> getAllConscriptions() {
        List<conscription> conscriptions = conscriptionService.getAll();
        return responseMessage.success(conscriptions);
    }

    // 根据学生 ID 获取征兵信息
    @GetMapping("/student/{studentId}")
    public responseMessage<List<conscription>> getConscriptionsByStudentId(@PathVariable int studentId) {
        List<conscription> conscriptions = conscriptionService.getByStudentId(studentId);
        return responseMessage.success(conscriptions);
    }

    // 根据管理员 ID 获取征兵信息
    @GetMapping("/admin/{adminId}")
    public responseMessage<List<conscription>> getConscriptionsByAdminId(@PathVariable int adminId) {
        List<conscription> conscriptions = conscriptionService.getByAdminId(adminId);
        return responseMessage.success(conscriptions);
    }
}