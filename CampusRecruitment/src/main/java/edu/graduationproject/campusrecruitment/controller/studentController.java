package edu.graduationproject.campusrecruitment.controller;

import edu.graduationproject.campusrecruitment.pojo.DTO.studentDTO;
import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import edu.graduationproject.campusrecruitment.pojo.student;
import edu.graduationproject.campusrecruitment.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //接口方法返回对象，对象转化为json
@RequestMapping("/student")  //url:  localhost:8088/student
public class studentController {

    @Autowired
    IStudentService studentService;

    //add a student
    @PostMapping //method: post
    public responseMessage<student> addStudent(@Validated @RequestBody studentDTO studentDTO) {
        student newStudent = studentService.add(studentDTO);
        return responseMessage.success(newStudent);
    }

    //delete student
    @DeleteMapping("/{studentId}") //method: delete, passing studentId as path variable
    public responseMessage<String> deleteStudent(@PathVariable int studentId) {
        boolean isDeleted = studentService.delete(studentId);
        if (isDeleted) {
            return responseMessage.success("Student with ID " + studentId + " deleted successfully.");
        } else {
            return responseMessage.error("Student with ID " + studentId + " not found.");
        }
    }

    //update student
    @PutMapping("/{studentId}") //method: put, passing studentId as path variable
    public responseMessage<student> updateStudent(@PathVariable int studentId, @Validated @RequestBody studentDTO studentDTO) {
        Optional<student> updatedStudent = studentService.update(studentId, studentDTO);
        if (updatedStudent.isPresent()) {
            return responseMessage.success(updatedStudent.get());
        } else {
            return responseMessage.error("Student with ID " + studentId + " not found.");
        }
    }

    //select student by id
    @GetMapping("/{studentId}") //method: get, passing studentId as path variable
    public responseMessage<student> getStudentById(@PathVariable int studentId) {
        Optional<student> studentOptional = studentService.getById(studentId);
        return studentOptional
                .map(responseMessage::success)
                .orElseGet(() -> responseMessage.error("Student with ID " + studentId + " not found."));
    }

    //select all students
    @GetMapping() //method: get
    public responseMessage<List<student>> getAllStudents() {
        List<student> students = studentService.getAll();
        return responseMessage.success(students);
    }
}
