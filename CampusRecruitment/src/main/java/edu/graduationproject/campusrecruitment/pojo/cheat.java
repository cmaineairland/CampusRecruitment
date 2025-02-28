package edu.graduationproject.campusrecruitment.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class cheat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sen_id")
    private int senId;

    @Column(name = "role", length = 20)
    private String role;

    @Column(name = "sentence", length = 256)
    private String sentence;

    // Getters and Setters
    public int getSenId() {
        return senId;
    }

    public void setSenId(int senId) {
        this.senId = senId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "News{" +
                "senId=" + senId +
                ", role='" + role + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}