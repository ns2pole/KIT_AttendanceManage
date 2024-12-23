package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class Webcontroller {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/history")
    public String history(){

        return "history";
    }
    @GetMapping("/leave-application")
    public String leaveapplication(){
        return "leaveapplication";
    }
    @GetMapping("/leave-approval")
    public String leaveapproval(){

        return "leaveapproval";
    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/status")
    public String status() {
        return "status";
    }
    @GetMapping("/workplace")
    public String workplace(){

        return "workplace";
    }
}
