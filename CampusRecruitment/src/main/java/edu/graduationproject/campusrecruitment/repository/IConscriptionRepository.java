package edu.graduationproject.campusrecruitment.repository;

import edu.graduationproject.campusrecruitment.pojo.conscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConscriptionRepository extends JpaRepository<conscription, Integer> {
    List<conscription> findByStudentId(int studentId);
    List<conscription> findByAdminId(int adminId);
}