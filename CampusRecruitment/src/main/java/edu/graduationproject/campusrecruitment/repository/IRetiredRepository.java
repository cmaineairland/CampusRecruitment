package edu.graduationproject.campusrecruitment.repository;

import edu.graduationproject.campusrecruitment.pojo.retired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IRetiredRepository extends JpaRepository<retired, Integer> {
    // 你可以在这里添加自定义的查询方法
    // 例如，根据学生 ID 获取退役复学信息
    List<retired> findByStudentId(int studentId);
    // 根据管理员 ID 获取退役复学信息
    List<retired> findByAdminId(int adminId);
}