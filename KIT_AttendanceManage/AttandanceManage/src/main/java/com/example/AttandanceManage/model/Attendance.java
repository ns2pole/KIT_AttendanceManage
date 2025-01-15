package com.example.AttandanceManage.model;


import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "attendance") // テーブル名
public class Attendance {


    @Id

    private Integer id;  // 主キー

    @Column(name = "出勤", nullable = false)
    private LocalTime checkIn;

    @Column(name = "退勤")
    private LocalTime checkOut;

    @Column(name = "休憩", nullable = false)
    private Duration breakTime;

    @Column(name = "総時間", insertable = false, updatable = false)
    private Duration totalHours;

    // ゲッターとセッター
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public Duration getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Duration breakTime) {
        this.breakTime = breakTime;
    }

    public Duration getTotalHours() {
        return totalHours;
    }
}