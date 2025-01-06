package com.example.AttandanceManage;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 自動生成されるIDフィールド

    private String password;
    private String name;
    private String role;
    public MyUser(Long id, String password, String name, String role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "id:" + this.id + "//" + "名前" + this.name + "パスワード" + this.password;
    }


}