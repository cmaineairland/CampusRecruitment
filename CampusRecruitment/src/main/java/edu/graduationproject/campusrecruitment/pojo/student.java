package edu.graduationproject.campusrecruitment.pojo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_id")
    private int studentId;

    @Column(name = "Student_name", length = 20, nullable = false)
    private String studentName;

    @Column(name = "Phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @Column(name = "Enter_school_year")
    private String enterSchoolYear;

    @Column(name = "college", length = 20, nullable = false)
    private String college;

    @Column(name = "photo", length = 256)
    private String photo;

    @Column(name = "Major", length = 20, nullable = false)
    private String major;

    @Column(name = "Class", length = 20, nullable = false)
    private String studentClass;

    @Column(name = "ethnic", length = 16, nullable = false)
    private String ethnic;

    @Column(name = "political", length = 16, nullable = false)
    private String political;

    @Column(name = "address", length = 256)
    private String address;

    public int getStudentId() {
        return studentId;
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

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", enterSchoolYear='" + enterSchoolYear + '\'' +
                ", college='" + college + '\'' +
                ", photo='" + photo + '\'' +
                ", major='" + major + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", political='" + political + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
