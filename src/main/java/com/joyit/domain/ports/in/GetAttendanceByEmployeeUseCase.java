package com.joyit.domain.ports.in;

import com.joyit.domain.model.Attendance;
import java.util.List;

public interface GetAttendanceByEmployeeUseCase {
    List<Attendance> obtenerPorEmpleado(Long employeeId);
}
