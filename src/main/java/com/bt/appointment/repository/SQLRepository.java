package com.bt.appointment.repository;

import com.bt.appointment.entity.AppointmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SQLRepository extends JpaRepository<AppointmentEntity, Long> {
    List<AppointmentEntity> findByStatus(String status);
}
