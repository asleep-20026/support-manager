package com.joyit.infrastructure.graphql.resolvers;

import com.joyit.domain.model.Attendance;
import com.joyit.domain.ports.in.GetAttendanceByEmployeeUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@ApplicationScoped
public class AttendanceResolver {

    private final GetAttendanceByEmployeeUseCase getAttendanceByEmployeeUseCase;

    @Inject
    public AttendanceResolver(GetAttendanceByEmployeeUseCase getAttendanceByEmployeeUseCase) {
        this.getAttendanceByEmployeeUseCase = getAttendanceByEmployeeUseCase;
    }

    public List<Attendance> consultarAsistencias(Long empleadoId) {
        return getAttendanceByEmployeeUseCase.obtenerPorEmpleado(empleadoId);
    }
}
