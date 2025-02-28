package edu.graduationproject.campusrecruitment.pojo.DTO;

import java.util.Date;

public class studentDTO {

    private int studentId;
    private String studentName;
    private String phoneNumber;
    private String enterSchoolYear;
    private String college;
    private String photo;
    private String major;
    private String ethnic;
    private String political;
    private String address;
    private String studentClass;

    public int getStudentId() {
        return studentId;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEnterSchoolYear() {
        return enterSchoolYear;
    }

    public void setEnterSchoolYear(String enterSchoolYear) {
        this.enterSchoolYear = enterSchoolYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "studentDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", enterSchoolYear='" + enterSchoolYear + '\'' +
                ", college='" + college + '\'' +
                ", photo='" + photo + '\'' +
                ", major='" + major + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", political='" + political + '\'' +
                ", address='" + address + '\'' +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}
