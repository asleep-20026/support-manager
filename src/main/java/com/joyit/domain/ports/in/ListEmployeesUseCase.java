package com.joyit.domain.ports.in;

import com.joyit.domain.model.Employee;
import java.util.List;

public interface ListEmployeesUseCase {
    List<Employee> listar();
}