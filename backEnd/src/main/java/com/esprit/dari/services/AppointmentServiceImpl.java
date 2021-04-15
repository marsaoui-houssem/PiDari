package com.esprit.dari.services;

import com.esprit.dari.dao.AdRepository;
import com.esprit.dari.dao.AppointmentRepository;
import com.esprit.dari.dao.UserDariRepository;
import com.esprit.dari.entities.Appointment;
import com.esprit.dari.entities.Notification;

import com.esprit.dari.entities.NotificationType;
import com.esprit.dari.services.interfaces.NotificationService;



import com.esprit.dari.services.interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import tn.dari.spring.service.interfaces.PriceHistoryService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    NotificationService notificationService;

    @Autowired
    AppointmentRepository appRep;
    @Autowired
    AdRepository estRep;
    @Autowired
    UserDariRepository UserRep;



    @Override
    public void UpdateApp( Appointment app, Long AppointmentId) {

        Appointment ap = appRep.findById(AppointmentId).get();

        app.setUser(ap.getUser());
        app.setAds(ap.getAds());



        app.setIdApp(AppointmentId);

        appRep.save(app);


    }

    @Override
    public Long AddAppointment(Appointment app, Long userId, Long adId) {

        app.setAds(estRep.findByidAd(adId));
        app.setUser(UserRep.findByUserId(userId));

        //app.getUser(UserRep.findByUserId(userId));

        appRep.save(app);

        return app.getIdApp();

    }

    @Override
    public void DeleteAppointment(Long id) {


            appRep.deleteById(id);


    }


}
