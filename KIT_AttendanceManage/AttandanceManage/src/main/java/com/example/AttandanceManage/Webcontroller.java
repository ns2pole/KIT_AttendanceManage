package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class Webcontroller {
@Autowired
private JdbcTemplate jdbcTemplate;

    /** attendanceを表示*/
    @GetMapping("/attendance")
    public String showContactForm(Model model) {
       String sql = "SELECT status FROM myuser WHERE id = 1";
        Map<String,Object> status = jdbcTemplate.queryForList(sql).get(0);
        System.out.println(status.get("status"));
        model.addAttribute("message", status.get("status"));
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
