package com.esprit.dari.services.AdAppointmentService;

import com.esprit.dari.entities.AdAppointment.NotificationType;
import com.esprit.dari.services.AdAppointmentService.interfaces.AdFavService;
import com.esprit.dari.dao.AdAppointmentRepository.AppointmentRepository;
import com.esprit.dari.dao.AdAppointmentRepository.NotificationRepository;

import com.esprit.dari.dao.userrepository.UserDariRepository;
import com.esprit.dari.entities.AdAppointment.Notification;
import com.esprit.dari.services.AdAppointmentService.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import tn.dari.spring.service.interfaces.PriceHistoryService;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    AppointmentRepository appRep;
    @Autowired
    UserDariRepository userRep;
    @Autowired
    NotificationRepository notifRep;
    @Autowired
    AdFavService favService;


    //for testing only
    @Override
    public Notification add(NotificationType notype,Long userId,Long appointmentId) {
        Notification notification =new Notification();


        notification.setUser(userRep.findByUserId(userId));
        notification.setAppointment(appRep.findById(appointmentId).get());
        notification.setNotifType(notype);


        notification.setRead(false);
        notifRep.save(notification);
        return notification;
    }

    @Override
    public int delete(Notification notification) {
        notifRep.delete(notification);
        return 1;
    }

    @Override
    public int deleteById(int notificationId) {
        notifRep.deleteById(notificationId);
        return 1;
    }

    @Override
    public Notification update(Notification notification, int id) {
        notification.setUser(notifRep.findById(id).get().getUser());
        notification.setAppointment(notifRep.findById(id).get().getAppointment());
        notification.setNotificationId(id);
        notifRep.save(notification);
        return notification;
    }

    @Override
    public List<Notification> fetchAll() {
        return (List<Notification>) notifRep.findAll();
    }

    @Override
    public List<Notification> fetchUnread() {
        return notifRep.findByIsReadFalse();
    }
    @Override
    public void read(Notification notification){
        notification.setRead(true);
        notifRep.save(notification);
    }
}
