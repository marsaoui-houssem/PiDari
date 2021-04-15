package com.esprit.dari.dao.AdAppointmentRepository;


import com.esprit.dari.entities.AdAppointment.Notification;
import com.esprit.dari.entities.UserDari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

       public List<Notification> findByUser(UserDari user);
       public List<Notification> findByIsReadFalse();


}
