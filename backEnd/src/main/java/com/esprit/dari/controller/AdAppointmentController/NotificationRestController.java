package com.esprit.dari.controller.AdAppointmentController;

import com.esprit.dari.entities.AdAppointment.NotificationType;
import com.esprit.dari.services.AdAppointmentService.interfaces.AppointmentService;
import com.esprit.dari.entities.AdAppointment.Notification;
import com.esprit.dari.services.AdAppointmentService.interfaces.NotificationService;
import com.esprit.dari.dao.AdAppointmentRepository.NotificationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationRestController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    AppointmentService favService;
    @Autowired
    NotificationRepository notifRep;

    @PostMapping("/addnot")
    public int add(@RequestBody NotificationType nottype , @RequestParam("userid") Long userId, @RequestParam("appid") Long appointmentId){
        notificationService.add(nottype,appointmentId,userId);
        return 1;
    }

    @GetMapping("/getallnot")
    public List<Notification> getAll(){
        return notificationService.fetchAll();
    }

    @DeleteMapping("/deletenot")
    public void delete(@RequestParam("id")  int id){
        notificationService.deleteById(id);
    }

    @PutMapping("/updatenot")
    public Notification update(@RequestBody Notification notification,@RequestParam("id") int id){
        notificationService.update(notification, id);
        return notification;
    }
    //@GetMapping("/getunread")
    //public List<Notification> getUnread (@RequestParam("user_id") int userId){
        //return notificationService.fetchUnreadByUser(userId);
   // }
    @PutMapping("/readnot")
    public Notification read(@RequestParam("id") int id){
        Notification notification = notifRep.findById(id).get();
        notificationService.read(notification);
        return notification;
    }
}
