package com.example.AttandanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class Webcontroller {

    /** attendanceを表示*/
    @GetMapping("/attendance")
    public String showContactForm() {

        return "attendance";
    }

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
    public String showStatusPage() {
        return "status";
    }
    @GetMapping("/workplace")
    public String workplace(){

        return "workplace";
    }
}
