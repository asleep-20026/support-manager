package com.joyit.domain.ports.in;

import com.joyit.domain.model.Attendance;

public interface RegisterAttendanceUseCase {
    Attendance registrar(Attendance asistencia);
}
