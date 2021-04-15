package com.esprit.dari.dao.AdAppointmentRepository;


import com.esprit.dari.entities.AdAppointment.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {


}
