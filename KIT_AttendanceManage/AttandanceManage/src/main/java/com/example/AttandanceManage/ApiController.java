package com.example.AttandanceManage;



import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;

import java.time.Duration;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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
            String sql2 = "UPDATE myuser SET status = ? WHERE id = ?";
            jdbcTemplate.update(sql, Timestamp.from(checkInTime.toInstant()));
            jdbcTemplate.update(sql2, "出勤中", 1);

            return ResponseEntity.ok("出勤情報が登録できました");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("エラーが発生しました: " + e.getMessage());
        }
    }

    @PostMapping("/checkOut")


    public ResponseEntity<Map<String, Object>> checkOut(@RequestBody Map<String, String> requestData) {
        try {
            String checkOutTimeS = requestData.get("checkOutTime");

            DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
            OffsetDateTime checkOutTime = OffsetDateTime.parse(checkOutTimeS, formatter);

            String sql = "UPDATE attendance SET 退勤 = ? WHERE 出勤 IS NOT NULL AND 退勤 IS NULL";
            String sql2 = "UPDATE myuser SET status = ? WHERE id = ?";

            jdbcTemplate.update(sql, Timestamp.from(checkOutTime.toInstant()));
            jdbcTemplate.update(sql2, "退勤中", 1);

            // 成功時にJSONレスポンスを返す
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "退勤情報が登録できました");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "エラーが発生しました: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/startBreak")
    public ResponseEntity<Map<String, Object>> startBreak(@RequestBody Map<String, String> requestData) {
        try {
            String breakStartTimeS = requestData.get("breakStartTime");
            OffsetDateTime breakStartTime = OffsetDateTime.parse(breakStartTimeS);

            // SQL文で休憩開始時間を更新
            String sql = "UPDATE attendance SET 休憩終了 = NULL WHERE 出勤 IS NOT NULL AND 退勤 IS NULL";
            jdbcTemplate.update(sql);

            // 正しいJSON形式でレスポンスを作成
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "休憩を開始しました。");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();

            // エラー時のレスポンスもJSON形式に統一
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "エラーが発生しました: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/endBreak")
    public ResponseEntity<Map<String, Object>> endBreak(@RequestBody Map<String, String> requestData) {
        try {
            String breakEndTimeS = requestData.get("breakEndTime");
            OffsetDateTime breakEndTime = OffsetDateTime.parse(breakEndTimeS);

            // SQL文で休憩終了時間を更新
            String sql = "UPDATE attendance SET 休憩終了 = ? WHERE 出勤 IS NOT NULL AND 退勤 IS NULL";
            jdbcTemplate.update(sql, Timestamp.from(breakEndTime.toInstant()));

            // 正しいJSON形式でレスポンスを作成
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "休憩を終了しました。");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();

            // エラー時のレスポンスもJSON形式に統一
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "エラーが発生しました: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


@GetMapping("/attendanceList")
         public ResponseEntity<List<Map<String, Object>>> getAttendanceList () {
             String sql = "SELECT 出勤, 退勤 FROM attendance";
             List<Map<String, Object>> attendanceList = jdbcTemplate.queryForList(sql);
             return ResponseEntity.ok(attendanceList);
         }
     }

