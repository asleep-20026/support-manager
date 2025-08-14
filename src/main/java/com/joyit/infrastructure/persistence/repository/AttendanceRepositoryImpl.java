package com.joyit.infrastructure.persistence.repository;

import com.joyit.domain.model.Attendance;
import com.joyit.domain.ports.out.AttendanceRepository;
import com.joyit.infrastructure.persistence.entity.AttendanceEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AttendanceRepositoryImpl implements AttendanceRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Attendance save(Attendance attendance) {
        AttendanceEntity entity = new AttendanceEntity();
        entity.setId(attendance.getId());
        entity.setTipo(attendance.getTipo());
        entity.setFecha(attendance.getFecha());
        entity.setEmpleadoId(attendance.getEmpleadoId());
        entityManager.persist(entity);
        return attendance;
    }

    @Override
    public List<Attendance> findByEmployeeId(Long employeeId) {
        List<AttendanceEntity> entities = entityManager
            .createQuery("SELECT a FROM AttendanceEntity a WHERE a.empleadoId = :id", AttendanceEntity.class)
            .setParameter("id", employeeId)
            .getResultList();

        return entities.stream().map(entity -> new Attendance(
            entity.getId(),
            entity.getTipo(),
            entity.getFecha(),
            entity.getEmpleadoId()
        )).collect(Collectors.toList());
    }
}
