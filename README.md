package com.example.AttandanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Webcontroller {
    @GetMapping("/attendance")
    public String attendance(){return  "attendance";}

    @GetMapping("/contact")
    public String contact(){return  "contact";}
    @GetMapping("/history")
    public String history(){return  "history";}
    @GetMapping("/leave-application")
    public String leaveapplication(){return "leave-application";}
    @GetMapping("/leave-approval")
    public String leaveapproval(){return  "leave-appproval";}
    @GetMapping("/login")
    public String login(){return  "login";}
    @GetMapping("/status")
    public String status(){return  "status";}
    @GetMapping("/workplace")
    public String workplace(){return  "workplace";}

    
}
