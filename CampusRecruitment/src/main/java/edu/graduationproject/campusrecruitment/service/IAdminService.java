package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.DTO.adminDTO;
import edu.graduationproject.campusrecruitment.pojo.admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {
    /*
     * insert admin
     * @param adminDTO
     * @return admin
     */
    admin add(adminDTO admin);

    /*
     * delete admin by adminId
     * @param adminId
     * @return boolean - true if deleted successfully, false otherwise
     */
    boolean delete(int adminId);

    /*
     * update admin by adminId
     * @param adminId
     * @param adminDTO
     * @return Optional<admin> - updated admin if found, empty if not found
     */
    Optional<admin> update(int adminId, adminDTO admin);

    /*
     * get admin by adminId
     * @param adminId
     * @return Optional<admin> - admin if found, empty if not found
     */
    Optional<admin> getById(int adminId);

    /*
     * get all admins
     * @return List<admin> - list of all admins
     */
    List<admin> getAll();
}