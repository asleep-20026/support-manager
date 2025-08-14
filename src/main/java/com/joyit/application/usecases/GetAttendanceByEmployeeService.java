package com.joyit.application.usecases;

import com.joyit.domain.model.Attendance;
import com.joyit.domain.ports.in.GetAttendanceByEmployeeUseCase;
import com.joyit.domain.ports.out.AttendanceRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetAttendanceByEmployeeService implements GetAttendanceByEmployeeUseCase {

    private final AttendanceRepository attendanceRepository;

    @Inject
    public GetAttendanceByEmployeeService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> obtenerPorEmpleado(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }
}
