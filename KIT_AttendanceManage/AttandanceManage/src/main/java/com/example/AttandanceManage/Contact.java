package com.example.AttandanceManage;

public class Contact {

    private String phone;
    private String email;

    // コンストラクタ
    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    // getterとsetter
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
