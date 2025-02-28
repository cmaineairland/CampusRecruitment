package edu.graduationproject.campusrecruitment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CallPythonFunction {
    public static void main(String[] args) {
        try {
            // 使用 ProcessBuilder 执行 Python 脚本，并传递参数
            ProcessBuilder processBuilder = new ProcessBuilder("python", "C:\\Users\\19397\\Desktop\\CampusRecruitment\\shell\\LLMs.py", "你好");
            Process process = processBuilder.start();

            // 获取脚本执行的输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            line = reader.readLine();
            System.out.println(line);

            // 等待脚本执行完成，并获取退出状态码
            int exitCode = process.waitFor();


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}