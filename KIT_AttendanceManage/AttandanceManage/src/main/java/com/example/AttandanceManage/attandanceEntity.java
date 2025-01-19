package com.example.AttandanceManage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class attandanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp 出勤;
    private Timestamp 退勤;
    private String 休憩;

    // ゲッターとセッターを省略

    public void Attendance() {}

    public void Attendance(Timestamp 出勤, Timestamp 退勤, String 休憩) {
        this.出勤 = 出勤;
        this.退勤 = 退勤;
        this.休憩 = 休憩;
    }

    // ゲッターとセッター
    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp get出勤() {
        return 出勤;
    }

    public void set出勤(Timestamp 出勤) {
        this.出勤 = 出勤;
    }

    public Timestamp get退勤() {
        return 退勤;
    }

    public void set退勤(Timestamp 退勤) {
        this.退勤 = 退勤;
    }

    public String get休憩() {
        return 休憩;
    }

    public void set休憩(String 休憩) {
        this.休憩 = 休憩;
    }
}
