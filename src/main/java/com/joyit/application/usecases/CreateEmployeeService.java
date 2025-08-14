package com.joyit.application.usecases;

import com.joyit.domain.model.Employee;
import com.joyit.domain.ports.in.CreateEmployeeUseCase;
import com.joyit.domain.ports.out.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateEmployeeService implements CreateEmployeeUseCase {

    @Inject
    EmployeeRepository repository;

    @Override
    public Employee crear(Employee empleado) {
        return repository.save(empleado);
    }

}