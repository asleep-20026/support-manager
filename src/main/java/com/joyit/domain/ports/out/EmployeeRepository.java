package com.joyit.domain.ports.out;

import com.joyit.domain.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee empleado);
    Employee edit(Employee empleado);
    Optional<Employee> findById(Long id);
    Optional<Employee> findByCorreo(String correo);
    List<Employee> findAll();
}