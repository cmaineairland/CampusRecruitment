package edu.graduationproject.campusrecruitment.controller;

import edu.graduationproject.campusrecruitment.pojo.DTO.newsDTO;
import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import edu.graduationproject.campusrecruitment.pojo.news;
import edu.graduationproject.campusrecruitment.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/news")
public class newsController {

    @Autowired
    INewsService newsService;

    // add a news
    @PostMapping
    public responseMessage<news> addNews(@Validated @RequestBody newsDTO newsDTO) {
        news newNews = newsService.add(newsDTO);
        return responseMessage.success(newNews);
    }

    // delete news
    @DeleteMapping("/{newsId}")
    public responseMessage<String> deleteNews(@PathVariable int newsId) {
        boolean isDeleted = newsService.delete(newsId);
        if (isDeleted) {
            return responseMessage.success("News with ID " + newsId + " deleted successfully.");
        } else {
            return responseMessage.error("News with ID " + newsId + " not found.");
        }
    }

    // update news
    @PutMapping("/{newsId}")
    public responseMessage<news> updateNews(@PathVariable int newsId, @Validated @RequestBody newsDTO newsDTO) {
        Optional<news> updatedNews = newsService.update(newsId, newsDTO);
        if (updatedNews.isPresent()) {
            return responseMessage.success(updatedNews.get());
        } else {
            return responseMessage.error("News with ID " + newsId + " not found.");
        }
    }

    // select news by id
    @GetMapping("/{newsId}")
    public responseMessage<news> getNewsById(@PathVariable int newsId) {
        Optional<news> newsOptional = newsService.getById(newsId);
        return newsOptional
                .map(responseMessage::success)
                .orElseGet(() -> responseMessage.error("News with ID " + newsId + " not found."));
    }

    // select all news
    @GetMapping()
    public responseMessage<List<news>> getAllNews() {
        try {
            // 构建要执行的命令，这里假设 Python 解释器为 python3，脚本名为 test.py
            Process process = Runtime.getRuntime().exec("python C:\\Users\\19397\\Desktop\\CampusRecruitment\\shell\\getNews.py");


            // 等待脚本执行完成，并获取退出状态码
            int exitCode = process.waitFor();
            System.out.println("脚本执行完成，退出状态码: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        List<news> newsList = newsService.getAll();
        return responseMessage.success(newsList);
    }
}