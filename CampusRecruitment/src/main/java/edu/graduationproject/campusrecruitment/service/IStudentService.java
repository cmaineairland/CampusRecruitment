package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.studentDTO;
import edu.graduationproject.campusrecruitment.pojo.student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    /*
     * insert student
     * @param studentDTO
     * @return student
     */
    student add(studentDTO student);

    /*
     * delete student by studentId
     * @param studentId
     * @return boolean - true if deleted successfully, false otherwise
     */
    boolean delete(int studentId);

    /*
     * update student by studentId
     * @param studentId
     * @param studentDTO
     * @return Optional<student> - updated student if found, empty if not found
     */
    Optional<student> update(int studentId, studentDTO student);

    /*
     * get student by studentId
     * @param studentId
     * @return Optional<student> - student if found, empty if not found
     */
    Optional<student> getById(int studentId);

    /*
     * get all students
     * @return List<student> - list of all students
     */
    List<student> getAll();
}
