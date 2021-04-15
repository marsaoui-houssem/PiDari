package com.esprit.dari.services.AdAppointmentService;

import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.AdAppointmentRepository.AppointmentRepository;
import com.esprit.dari.dao.userrepository.UserDariRepository;
import com.esprit.dari.entities.AdAppointment.Appointment;

import com.esprit.dari.services.AdAppointmentService.interfaces.NotificationService;



import com.esprit.dari.services.AdAppointmentService.interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
