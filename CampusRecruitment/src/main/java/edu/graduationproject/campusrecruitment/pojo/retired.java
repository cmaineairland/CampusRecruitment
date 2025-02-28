package edu.graduationproject.campusrecruitment.pojo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "retired")
public class retired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retired_id")
    private int retiredId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "Admin_id")
    private int adminId;

    @Column(name = "state")
    private String state;

    @Column(name = "retired_time")
    private Date retiredTime;

    @Column(name = "remark")
    private String remark;

    // Getters and Setters
    public int getRetiredId() {
        return retiredId;
    }

    public void setRetiredId(int retiredId) {
        this.retiredId = retiredId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRetiredTime() {
        return retiredTime;
    }

    public void setRetiredTime(Date retiredTime) {
        this.retiredTime = retiredTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "retired{" +
                "retiredId=" + retiredId +
                ", studentId=" + studentId +
                ", adminId=" + adminId +
                ", state='" + state + '\'' +
                ", retiredTime=" + retiredTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}