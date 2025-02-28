package edu.graduationproject.campusrecruitment.pojo.DTO;

import java.util.Date;

public class conscriptionDTO {

    private int conscriptionId;

    private int studentId;

    private int adminId;

    private String intention;

    private String state;

    private Date conscriptionTime;

    private String remark;

    // Getters and Setters
    public int getConscriptionId() {
        return conscriptionId;
    }

    public void setConscriptionId(int conscriptionId) {
        this.conscriptionId = conscriptionId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getConscriptionTime() {
        return conscriptionTime;
    }

    public void setConscriptionTime(Date conscriptionTime) {
        this.conscriptionTime = conscriptionTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}