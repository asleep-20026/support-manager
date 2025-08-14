package com.joyit.infrastructure.graphql.resolvers;

import com.joyit.domain.model.Employee;
import com.joyit.domain.ports.in.CreateEmployeeUseCase;
import com.joyit.domain.ports.in.EditEmployeeUseCase;
import com.joyit.domain.ports.in.ListEmployeesUseCase;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Name;

import java.util.List;

@GraphQLApi
public class EmployeeResolver {

    @Inject
    CreateEmployeeUseCase crearEmpleadoUseCase;

    @Inject
    EditEmployeeUseCase editarEmpleadoUseCase;

    @Inject
    ListEmployeesUseCase listarEmpleadosUseCase;

    @Mutation
    public Employee crearEmpleado(@Name("nombre") String nombre,
                                  @Name("correo") String correo,
                                  @Name("faceID") String faceID) {
        Employee empleado = new Employee(null, nombre, correo, faceID);
        return crearEmpleadoUseCase.crear(empleado);
    }

    @Mutation
    public Employee editarEmpleado(@Name("id") Long id,
                                   @Name("nombre") String nombre,
                                   @Name("correo") String correo,
                                   @Name("faceID") String faceID) {
        Employee empleado = new Employee(id, nombre, correo, faceID);
        return editarEmpleadoUseCase.editar(empleado);
    }

    @Query
    public List<Employee> listarEmpleados() {
        return listarEmpleadosUseCase.listar();
    }
}