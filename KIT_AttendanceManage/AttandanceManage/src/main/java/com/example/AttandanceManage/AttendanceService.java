package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Attendance> getAllAttendances() {
        String sql = "SELECT id, name FROM attendance";

        return jdbcTemplate.query(sql, new RowMapper<Attendance>() {
            @Override
            public Attendance mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Attendance attendance = new Attendance();
                attendance.setId(rs.getInt("id"));
                attendance.setName(rs.getString("name"));
                return attendance;
            }
        });
    }
}