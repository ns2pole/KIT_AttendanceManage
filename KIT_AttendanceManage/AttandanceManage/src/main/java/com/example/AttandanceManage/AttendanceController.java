package com.example.AttandanceManage;

import com.example.AttandanceManage.model.Attendance;
import com.example.AttandanceManage.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance") // URLのパスを指定
public class AttendanceController {

    // AttendanceRepositoryを注入
    @Autowired
    private AttendanceRepository attendanceRepository;

    // 出勤・退勤データを取得するエンドポイント
    @GetMapping("/list")
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();  // リポジトリから全てのデータを取得
    }

    // 出勤データを追加するエンドポイント
    @PostMapping("/add")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceRepository.save(attendance);  // データを保存
        return ResponseEntity.ok(savedAttendance);  // 保存したデータを返却
    }

    // 出勤データを更新するエンドポイント
    @PutMapping("/update/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance updatedAttendance) {
        return attendanceRepository.findById(id)
                .map(attendance -> {
                   attendance.setCheckIn(updatedAttendance.getCheckIn());
                   attendance.setCheckOut(updatedAttendance.getCheckOut());
                   attendance.setBreakTime(updatedAttendance.getBreakTime());
                   attendanceRepository.save(attendance);
                   return ResponseEntity.ok(attendance);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 出勤データを削除するエンドポイント
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        return attendanceRepository.findById(id)
                .map(attendance -> {
                    attendanceRepository.delete(attendance);
                    return ResponseEntity.noContent().build();  // 削除成功
                })
                .orElseGet(() -> ResponseEntity.notFound().build());  // データが見つからない場合
    }

     */
}
