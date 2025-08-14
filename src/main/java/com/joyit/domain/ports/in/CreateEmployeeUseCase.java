package com.joyit.domain.ports.in;

import com.joyit.domain.model.Employee;

public interface CreateEmployeeUseCase {
    Employee crear(Employee empleado);
}