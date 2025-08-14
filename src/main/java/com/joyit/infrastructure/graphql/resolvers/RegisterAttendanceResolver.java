package com.joyit.infrastructure.graphql.resolvers;

import com.joyit.domain.model.Attendance;
import com.joyit.domain.ports.in.RegisterAttendanceUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

@GraphQLApi
@ApplicationScoped
public class RegisterAttendanceResolver {

    private final RegisterAttendanceUseCase registerAttendanceUseCase;

    @Inject
    public RegisterAttendanceResolver(RegisterAttendanceUseCase registerAttendanceUseCase) {
        this.registerAttendanceUseCase = registerAttendanceUseCase;
    }

    @Mutation("registrarAsistencia")
    public Attendance registrarAsistencia(Long id, String tipo, String fecha, Long empleadoId) {
        Attendance asistencia = new Attendance(id, tipo, java.time.LocalDate.parse(fecha), empleadoId);
        return registerAttendanceUseCase.registrar(asistencia);
    }
}
