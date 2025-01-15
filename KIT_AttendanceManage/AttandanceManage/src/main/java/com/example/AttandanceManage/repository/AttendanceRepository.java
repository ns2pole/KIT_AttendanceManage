
package com.example.AttandanceManage.repository;

import com.example.AttandanceManage.model.Attendance;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
  /*
    Attendance save(Attendance attendance);

    List<Attendance> findAll();

    ObservationFilter findById(Long id);

    void delete(Object attendance);

*/


    // 必要なクエリメソッドを定義
}
