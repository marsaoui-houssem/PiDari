package com.esprit.dari.dao;


import com.esprit.dari.entities.Notification;
import com.esprit.dari.entities.UserDari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;


@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

       public List<Notification> findByUser(UserDari user);
       public List<Notification> findByIsReadFalse();


}
