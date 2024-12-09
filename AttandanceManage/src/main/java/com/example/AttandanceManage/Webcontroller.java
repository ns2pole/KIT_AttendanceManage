package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;




@Controller
public class Webcontroller {
    @Autowired
    private JdbcTemplate jdbcTemplate;
 @GetMapping("/attendance")
 public String index(Model model) {
     String sql = "SElECT * FROM ATTENDANXES";

     System.out.println(jdbcTemplate.queryForList(sql));
     return "attendance";
 }


    @GetMapping("/attendance")
    public String attendance(){
        return "attendance";
    }

    @GetMapping("/contact")
    public String contact(){

        return "contact";
    }
    @GetMapping("/history")
    public String index(){
        return "history";
    }

    @GetMapping("/history")
    public String history(){
        return "history";
    }

    @GetMapping("/leave-application")
    public String leaveapplication(){
        return "leave-application";
    }
    @GetMapping("/leave-approval")
    public String leaveapproval(){

        return "leave-approval";
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
