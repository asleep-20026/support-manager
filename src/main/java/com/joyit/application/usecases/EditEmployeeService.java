package com.joyit.application.usecases;

import com.joyit.domain.model.Employee;
import com.joyit.domain.ports.in.EditEmployeeUseCase;
import com.joyit.domain.ports.out.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EditEmployeeService implements EditEmployeeUseCase {

    @Inject
    EmployeeRepository repository;

    @Override
    public Employee editar(Employee empleado) {
        return repository.edit(empleado);
    }
}
