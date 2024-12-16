package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Webcontroller {

    @Autowired
    AttendanceService attendanceService;
    @GetMapping("/attendance")
    public String attendance(){

        return "attendance";
    }

    @GetMapping("/history")
    public String history(Authentication authentication , Model model){
        if (authentication.getAuthorities().stream()
                .noneMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/login";
        }
        model.addAttribute("attendances", attendanceService.getAllAttendances());
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
    public String status()
    {
        return "status";
    }
    @GetMapping("/workplace")
    public String workplace(){

        return "workplace";
    }
}
