package edu.graduationproject.campusrecruitment.controller;

import edu.graduationproject.campusrecruitment.pojo.DTO.cheatDTO;
import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import edu.graduationproject.campusrecruitment.pojo.cheat;
import edu.graduationproject.campusrecruitment.service.ICheatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cheat")
public class cheatController {

    @Autowired
    ICheatService cheatService;

    // add a cheat
    @PostMapping
    public responseMessage<cheat> addCheat(@Validated @RequestBody cheatDTO cheatDTO) {
        // 先保存用户发来的 cheatDTO
        cheat newCheat = cheatService.add(cheatDTO);

        // 创建一个新线程来执行 Python 脚本
        if(cheatDTO.getRole().equals("user")){
            new Thread(new PythonScriptRunner(cheatDTO, cheatService)).start();
        }


        return responseMessage.success(newCheat);
    }

    // delete cheat
    @DeleteMapping("/{senId}")
    public responseMessage<String> deleteCheat(@PathVariable int senId) {
        boolean isDeleted = cheatService.delete(senId);
        if (isDeleted) {
            return responseMessage.success("Cheat with ID " + senId + " deleted successfully.");
        } else {
            return responseMessage.error("Cheat with ID " + senId + " not found.");
        }
    }

    // update cheat
    @PutMapping("/{senId}")
    public responseMessage<cheat> updateCheat(@PathVariable int senId, @Validated @RequestBody cheatDTO cheatDTO) {
        Optional<cheat> updatedCheat = cheatService.update(senId, cheatDTO);
        if (updatedCheat.isPresent()) {
            return responseMessage.success(updatedCheat.get());
        } else {
            return responseMessage.error("Cheat with ID " + senId + " not found.");
        }
    }

    // select cheat by id
    @GetMapping("/{senId}")
    public responseMessage<cheat> getCheatById(@PathVariable int senId) {
        Optional<cheat> cheatOptional = cheatService.getById(senId);
        return cheatOptional
                .map(responseMessage::success)
                .orElseGet(() -> responseMessage.error("Cheat with ID " + senId + " not found."));
    }

    // select all cheats
    @GetMapping()
    public responseMessage<List<cheat>> getAllCheats() {
        List<cheat> cheats = cheatService.getAll();
        return responseMessage.success(cheats);
    }

    // 定义一个实现 Runnable 接口的类来执行 Python 脚本
    static class PythonScriptRunner implements Runnable {
        private final cheatDTO cheatDTO;
        private final ICheatService cheatService;

        public PythonScriptRunner(cheatDTO cheatDTO, ICheatService cheatService) {
            this.cheatDTO = cheatDTO;
            this.cheatService = cheatService;
        }

        @Override
        public void run() {
            String line = null;
            try {
                // 使用 ProcessBuilder 执行 Python 脚本，并传递参数
                ProcessBuilder processBuilder = new ProcessBuilder("python", "C:\\Users\\19397\\Desktop\\CampusRecruitment\\shell\\LLMs.py", cheatDTO.getSentence());
                Process process = processBuilder.start();

                // 获取脚本执行的输出流
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
                line = reader.readLine();
                System.out.println(line);

                // 等待脚本执行完成，并获取退出状态码
                int exitCode = process.waitFor();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            if (line != null) {
                // 创建新的 cheatDTO 对象 resByAI
                cheatDTO resByAI = new cheatDTO();
                resByAI.setRole("robot");
                resByAI.setSentence("(本内容由AI生成，请注意甄别信息)"+line);

                // 保存 resByAI
                cheatService.add(resByAI);
            }
        }
    }
}