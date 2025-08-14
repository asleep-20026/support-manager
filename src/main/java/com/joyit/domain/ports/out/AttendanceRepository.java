package com.joyit.domain.ports.out;

import com.joyit.domain.model.Attendance;
import java.util.List;

public interface AttendanceRepository {
    Attendance save(Attendance attendance);
    List<Attendance> findByEmployeeId(Long employeeId);
}
