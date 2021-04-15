package com.esprit.dari.controller.AdAppointmentController;

import com.esprit.dari.dao.AdAppointmentRepository.AppointmentRepository;
import com.esprit.dari.entities.AdAppointment.Appointment;
import com.esprit.dari.entities.AdAppointment.NotificationType;
import com.esprit.dari.services.AdAppointmentService.interfaces.AppointmentService;
import com.esprit.dari.services.AdAppointmentService.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentRestController {
    @Autowired
    private AppointmentRepository AppointmentRepository;
    @Autowired
    NotificationService notificationService;

    // URL : http://localhost:8081/dari/Appointment
    @GetMapping ("/Appointment")
    @ResponseBody
    public List<Appointment> AppointmentList(){
        return AppointmentRepository.findAll();

    }
    @PostMapping ("/Appointment")
    @ResponseBody
    public Appointment save(@RequestBody Appointment appointment){
        return AppointmentRepository.save(appointment);
    }

    @Autowired
    AppointmentService AppService;
    @PostMapping("/addAppointment")
    public Appointment AddAppointment(@RequestBody Appointment App, @RequestParam("iduser") Long userId, @RequestParam("idad") Long adId){
        Long appointmentId;

        NotificationType nottype=NotificationType.Apointment_Suggested;

        AppService.AddAppointment(App,userId,adId);
        appointmentId=App.getIdApp();
        notificationService.add(nottype,userId ,appointmentId);
        return App;
    }
    @PutMapping("/updateAppointment")
    public Appointment Update(@RequestBody Appointment app,@RequestParam("idapp") Long appId)
    {

        AppService.UpdateApp(app,appId);

        return app;
    }
}
