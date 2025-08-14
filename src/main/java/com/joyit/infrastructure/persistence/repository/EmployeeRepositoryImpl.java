package com.joyit.infrastructure.persistence.repository;

import com.joyit.domain.model.Employee;
import com.joyit.domain.ports.out.EmployeeRepository;
import com.joyit.infrastructure.persistence.entity.EmployeeEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public Employee save(Employee empleado) {
        EmployeeEntity e = new EmployeeEntity();
        e.nombre = empleado.getNombre();
        e.correo = empleado.getCorreo();
        e.faceID = empleado.getFaceID();

        em.persist(e);
        empleado.setId(e.id);
        return empleado;
    }

    @Override
    @Transactional
    public Employee edit(Employee empleado) {
        EmployeeEntity e = em.find(EmployeeEntity.class, empleado.getId());
        if (e != null) {
            e.nombre = empleado.getNombre();
            e.correo = empleado.getCorreo();
            e.faceID = empleado.getFaceID();
            em.merge(e);
            return new Employee(e.id, e.nombre, e.correo, e.faceID);
        }
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        EmployeeEntity e = em.find(EmployeeEntity.class, id);
        return Optional.ofNullable(e != null ? new Employee(e.id, e.nombre, e.correo, e.faceID) : null);
    }

    @Override
    public Optional<Employee> findByCorreo(String correo) {
        try {
            EmployeeEntity e = em.createQuery("FROM EmployeeEntity e WHERE e.correo = :correo", EmployeeEntity.class)
                                 .setParameter("correo", correo)
                                 .getSingleResult();
            return Optional.of(new Employee(e.id, e.nombre, e.correo, e.faceID));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery("FROM EmployeeEntity", EmployeeEntity.class)
                 .getResultList()
                 .stream()
                 .map(e -> new Employee(e.id, e.nombre, e.correo, e.faceID))
                 .collect(Collectors.toList());
    }
}