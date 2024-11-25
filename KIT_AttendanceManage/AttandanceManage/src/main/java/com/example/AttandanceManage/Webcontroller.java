package com.example.AttandanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Webcontroller {
    @GetMapping("/attendance.html")
    public String attendance(){
        return "attendance";
    }

    @GetMapping("/contact.html")
    public String contact(){

        return "contact";
    }
    @GetMapping("/history.html")
    public String history(){
        return "history";
    }
    @GetMapping("/leave-application.html")
    public String leaveapplication(){
        return "leaveapplication";
    }
    @GetMapping("/leave-approval.html")
    public String leaveapproval(){
        return "leaveapproval";
    }
    @GetMapping("/login.html")
    public String login(){
        return "login";
    }
    @GetMapping("/status.html")
    public String status(){
        return "status";
    }
    @GetMapping("/workplace.html")
    public String workplace(){

        return "workplace";
    }
}
