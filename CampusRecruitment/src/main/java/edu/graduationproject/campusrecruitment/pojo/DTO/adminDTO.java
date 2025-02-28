package edu.graduationproject.campusrecruitment.pojo.DTO;

public class adminDTO {
    private int adminId;
    private String adminName;
    private String workplace;

    public adminDTO() {
    }

    public adminDTO(int adminId, String adminName, String workplace) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.workplace = workplace;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
}