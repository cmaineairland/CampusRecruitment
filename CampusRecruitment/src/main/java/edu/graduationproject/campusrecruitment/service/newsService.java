package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.newsDTO;
import edu.graduationproject.campusrecruitment.pojo.news;
import edu.graduationproject.campusrecruitment.repository.INewsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class newsService implements INewsService {

    @Autowired
    INewsRepository newsRepository;

    @Override
    public news add(newsDTO newsDTO) {
        news newsPojo = new news();
        // 将 DTO 转换为实体类
        BeanUtils.copyProperties(newsDTO, newsPojo);
        return newsRepository.save(newsPojo);
    }

    @Override
    public boolean delete(int newsId) {
        Optional<news> newsOptional = newsRepository.findById(newsId);
        if (newsOptional.isPresent()) {
            newsRepository.delete(newsOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<news> update(int newsId, newsDTO newsDTO) {
        Optional<news> newsOptional = newsRepository.findById(newsId);
        if (newsOptional.isPresent()) {
            news existingNews = newsOptional.get();
            // 更新现有新闻对象的属性
            BeanUtils.copyProperties(newsDTO, existingNews, "newsId"); // 排除 newsId 不被覆盖
            return Optional.of(newsRepository.save(existingNews));
        }
        return Optional.empty();
    }

    @Override
    public Optional<news> getById(int newsId) {
        return newsRepository.findById(newsId);
    }

    @Override
    public List<news> getAll() {
        Iterable<news> newsIterable = newsRepository.findAll();
        return (List<news>) newsIterable;  // 方法 1: 直接转换
        // 或者使用 stream 转换为 List
        // return StreamSupport.stream(newsIterable.spliterator(), false)
        //        .collect(Collectors.toList());  // 方法 2: 使用 Stream
    }
}