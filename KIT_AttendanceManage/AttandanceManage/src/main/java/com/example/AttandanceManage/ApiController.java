package com.example.AttandanceManage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/api/attendance")
    public class ApiController {
        @Autowired
        private JdbcTemplate jdbcTemplate;

    @PostMapping("/checkIn")
    public ResponseEntity<String> checkIn(@RequestBody Map<String, String> requestData) {
        try {
            String checkInTimeS = requestData.get("checkInTime");


            DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
            OffsetDateTime checkInTime = OffsetDateTime.parse(checkInTimeS, formatter);


            LocalTime localTime = checkInTime.toLocalTime();

            String sql = "INSERT INTO attendance (出勤, 退勤, 休憩) VALUES (?, NULL, '00:00:00')";
            jdbcTemplate.update(sql, Timestamp.from(checkInTime.toInstant()));

            return ResponseEntity.ok("出勤情報が登録できました");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("エラーが発生しました: " + e.getMessage());
        }
    }

        @GetMapping("/attendanceList")
        public ResponseEntity<List<Map<String, Object>>> getAttendanceList() {
            String sql = "SELECT 出勤, 退勤 FROM attendance";
            List<Map<String, Object>> attendanceList = jdbcTemplate.queryForList(sql);
            return ResponseEntity.ok(attendanceList);
        }
    }

