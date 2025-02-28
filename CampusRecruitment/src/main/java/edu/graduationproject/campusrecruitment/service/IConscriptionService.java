package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.conscription;
import edu.graduationproject.campusrecruitment.pojo.DTO.conscriptionDTO;

import java.util.List;
import java.util.Optional;

public interface IConscriptionService {

    /*
     * insert conscription
     * @param conscriptionDTO
     * @return Conscription
     */
    conscription add(conscriptionDTO conscriptionDTO);

    /*
     * delete conscription by conscriptionId
     * @param conscriptionId
     * @return boolean - true if deleted successfully, false otherwise
     */
    boolean delete(int conscriptionId);

    /*
     * update conscription by conscriptionId
     * @param conscriptionId
     * @param conscriptionDTO
     * @return Optional<Conscription> - updated conscription if found, empty if not found
     */
    Optional<conscription> update(int conscriptionId, conscriptionDTO conscriptionDTO);

    /*
     * get conscription by conscriptionId
     * @param conscriptionId
     * @return Optional<Conscription> - conscription if found, empty if not found
     */
    Optional<conscription> getById(int conscriptionId);

    /*
     * get all conscriptions
     * @return List<Conscription> - list of all conscriptions
     */
    List<conscription> getAll();

    // 自定义方法示例：根据学生 ID 获取征兵信息
    List<conscription> getByStudentId(int studentId);

    // 自定义方法示例：根据管理员 ID 获取征兵信息
    List<conscription> getByAdminId(int adminId);
}