package com.joyit.application.usecases;

import com.joyit.domain.model.Employee;
import com.joyit.domain.ports.in.ListEmployeesUseCase;
import com.joyit.domain.ports.out.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ListEmployeeService implements ListEmployeesUseCase {

    @Inject
    EmployeeRepository repository;

    @Override
    public List<Employee> listar() {
        return repository.findAll();
    }
}