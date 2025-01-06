package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;


@Controller
public class Webcontroller {
    @Autowired
    private JdbcTemplate jdbcTemplate;

     @PostMapping("/checkIn")
     @ResponseBody
     public ResponseEntity<String> checkIn(@RequestBody Map<String, String> requestData) {
         String checkInTimeS = requestData.get("checkInTime");
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime checkInTime;
         try {
             checkInTime = LocalDateTime.parse(checkInTimeS, formatter);
         } catch (DateTimeParseException e) {
             return ResponseEntity.badRequest().body("Invalid date format. Expected format: yyyy/MM/dd HH:mm:ss.");
         }
         // LocalDateTime を Timestamp に変換して挿入
         String sql = "INSERT INTO attendance (出勤) VALUES (?)";
         try {
             jdbcTemplate.update(sql, Timestamp.valueOf(checkInTime));  // LocalDateTime -> Timestamp 変換
             return ResponseEntity.ok("出勤情報が登録できました");
         } catch (Exception e) {
             return ResponseEntity.status(500).body("データベースエラー: " + e.getMessage());
         }
     }
    @GetMapping("/attendanceList")
    public String index(Model model) {

        String sql = "SELECT * FROM attendance";
        List<Map<String, Object>> attendanceList = jdbcTemplate.queryForList(sql);
      System.out.println();
        model.addAttribute("attendanceList", attendanceList);
        return "attendance";
    }

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
    public String getstatus(Model model){

        return "status";
    }

    @GetMapping("/workplace")
    public String workplace(){

        return "workplace";
    }
}
