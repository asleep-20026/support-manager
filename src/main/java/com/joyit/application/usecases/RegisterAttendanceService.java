package com.joyit.application.usecases;

import com.joyit.domain.model.Attendance;
import com.joyit.domain.ports.in.RegisterAttendanceUseCase;
import com.joyit.domain.ports.out.AttendanceRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RegisterAttendanceService implements RegisterAttendanceUseCase {

    private final AttendanceRepository attendanceRepository;

    @Inject
    public RegisterAttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Attendance registrar(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}
