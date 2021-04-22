package com.esprit.dari.services.AdAppointmentService.interfaces;

import com.esprit.dari.entities.AdAppointment.Notification;

import com.esprit.dari.entities.AdAppointment.NotificationType;


import java.util.List;


public interface NotificationService {




        public Notification add(NotificationType nottype,Long userId, Long appointmentId);
        public Notification update(Notification notification, int id);
        public int delete(Notification notification);
        public int deleteById(int id);
        //public int create(double PriceChange, int announcementId);
       // public int create(NotificationType type, int announcementId);
        public void read(Notification notification);       // public void read(Notification notification);
       // public void unRead(int id);
       // public void unRead(Notification notification);
       // public void readAll(UserDari user);
        public List<Notification> fetchAll();
     //   public List<Notification> fetchUnreadByUser(int userId);
        public List<Notification> fetchUnread();


}
