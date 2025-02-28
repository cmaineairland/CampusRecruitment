package edu.graduationproject.campusrecruitment.repository;

import edu.graduationproject.campusrecruitment.pojo.cheat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheatRepository extends CrudRepository<cheat, Integer> {
    // 你可以在这里根据业务需求添加自定义的查询方法
    // 例如：Cheat findByRole(String role);
}