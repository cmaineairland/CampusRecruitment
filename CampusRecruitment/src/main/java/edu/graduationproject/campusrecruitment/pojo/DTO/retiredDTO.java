package edu.graduationproject.campusrecruitment.pojo.DTO;

import java.util.Date;

public class retiredDTO {

    private int retiredId;
    private int studentId;
    private int adminId;
    private String state;
    private Date retiredTime;
    private String remark;

    // Getters
    public int getRetiredId() {
        return retiredId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getState() {
        return state;
    }

    public Date getRetiredTime() {
        return retiredTime;
    }

    public String getRemark() {
        return remark;
    }

    // Setters
    public void setRetiredId(int retiredId) {
        this.retiredId = retiredId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRetiredTime(Date retiredTime) {
        this.retiredTime = retiredTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}