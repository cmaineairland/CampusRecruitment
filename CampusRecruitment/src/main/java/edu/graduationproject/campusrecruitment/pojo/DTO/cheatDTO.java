package edu.graduationproject.campusrecruitment.pojo.DTO;

public class cheatDTO {
    private int senId;
    private String role;
    private String sentence;

    // 无参构造函数
    public cheatDTO() {
    }

    // 有参构造函数
    public cheatDTO(int senId, String role, String sentence) {
        this.senId = senId;
        this.role = role;
        this.sentence = sentence;
    }

    // 获取 senId 的方法
    public int getSenId() {
        return senId;
    }

    // 设置 senId 的方法
    public void setSenId(int senId) {
        this.senId = senId;
    }

    // 获取 role 的方法
    public String getRole() {
        return role;
    }

    // 设置 role 的方法
    public void setRole(String role) {
        this.role = role;
    }

    // 获取 sentence 的方法
    public String getSentence() {
        return sentence;
    }

    // 设置 sentence 的方法
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}