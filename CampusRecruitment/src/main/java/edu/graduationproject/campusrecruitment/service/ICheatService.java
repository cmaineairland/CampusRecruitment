package edu.graduationproject.campusrecruitment.service;

import edu.graduationproject.campusrecruitment.pojo.cheat;
import edu.graduationproject.campusrecruitment.pojo.DTO.cheatDTO;
import java.util.List;
import java.util.Optional;

public interface ICheatService {
    cheat add(cheatDTO cheatDTO);
    boolean delete(int senId);
    Optional<cheat> update(int senId, cheatDTO cheatDTO);
    Optional<cheat> getById(int senId);
    List<cheat> getAll();
}