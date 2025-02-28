package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.studentDTO;
import edu.graduationproject.campusrecruitment.pojo.student;
import edu.graduationproject.campusrecruitment.repository.IStudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public student add(studentDTO studentDTO) {
        student studentPojo = new student();
        // 将 DTO 转换为实体类
        BeanUtils.copyProperties(studentDTO, studentPojo);
        return studentRepository.save(studentPojo);
    }

    @Override
    public boolean delete(int studentId) {
        Optional<student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<student> update(int studentId, studentDTO studentDTO) {
        Optional<student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            student existingStudent = studentOptional.get();
            // 更新现有学生对象的属性
            BeanUtils.copyProperties(studentDTO, existingStudent, "studentId"); // 排除 studentId 不被覆盖
            return Optional.of(studentRepository.save(existingStudent));
        }
        return Optional.empty();
    }

    @Override
    public Optional<student> getById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<student> getAll() {
        Iterable<student> studentsIterable = studentRepository.findAll();
        return (List<student>) studentsIterable;  // 方法 1: 直接转换
        // 或者使用 stream 转换为 List
        // return StreamSupport.stream(studentsIterable.spliterator(), false)
        //         .collect(Collectors.toList());  // 方法 2: 使用 Stream
    }
}
