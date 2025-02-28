package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.newsDTO;
import edu.graduationproject.campusrecruitment.pojo.news;

import java.util.List;
import java.util.Optional;

public interface INewsService {
    /*
     * insert news
     * @param newsDTO
     * @return news
     */
    news add(newsDTO news);

    /*
     * delete news by newsId
     * @param newsId
     * @return boolean - true if deleted successfully, false otherwise
     */
    boolean delete(int newsId);

    /*
     * update news by newsId
     * @param newsId
     * @param newsDTO
     * @return Optional<news> - updated news if found, empty if not found
     */
    Optional<news> update(int newsId, newsDTO news);

    /*
     * get news by newsId
     * @param newsId
     * @return Optional<news> - news if found, empty if not found
     */
    Optional<news> getById(int newsId);

    /*
     * get all news
     * @return List<news> - list of all news
     */
    List<news> getAll();
}