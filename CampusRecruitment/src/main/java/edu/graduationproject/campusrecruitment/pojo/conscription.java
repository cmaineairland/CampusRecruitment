package edu.graduationproject.campusrecruitment.pojo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "conscription")
public class conscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Conscription_id")
    private int conscriptionId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "Admin_id")
    private int adminId;

    @Column(name = "intention")
    private String intention;

    @Column(name = "state")
    private String state;

    @Column(name = "conscription_time")
    private Date conscriptionTime;

    @Column(name = "remark")
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

    @Override
    public String toString() {
        return "Conscription{" +
                "conscriptionId=" + conscriptionId +
                ", studentId=" + studentId +
                ", adminId=" + adminId +
                ", intention='" + intention + '\'' +
                ", state='" + state + '\'' +
                ", conscriptionTime=" + conscriptionTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}