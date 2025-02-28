package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.retiredDTO;
import edu.graduationproject.campusrecruitment.pojo.retired;

import java.util.List;
import java.util.Optional;

public interface IRetiredService {

    /*
     * insert retired
     * @param retiredDTO
     * @return retired
     */
    retired add(retiredDTO retiredDTO);

    /*
     * delete retired by retiredId
     * @param retiredId
     * @return boolean - true if deleted successfully, false otherwise
     */
    boolean delete(int retiredId);

    /*
     * update retired by retiredId
     * @param retiredId
     * @param retiredDTO
     * @return Optional<retired> - updated retired if found, empty if not found
     */
    Optional<retired> update(int retiredId, retiredDTO retiredDTO);

    /*
     * get retired by retiredId
     * @param retiredId
     * @return Optional<retired> - retired if found, empty if not found
     */
    Optional<retired> getById(int retiredId);

    /*
     * get all retireds
     * @return List<retired> - list of all retireds
     */
    List<retired> getAll();

    // 自定义方法：根据学生 ID 获取退役复学信息
    List<retired> getByStudentId(int studentId);

    // 自定义方法：根据管理员 ID 获取退役复学信息
    List<retired> getByAdminId(int adminId);
}