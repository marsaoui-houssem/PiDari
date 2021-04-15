package com.esprit.dari.services.interfaces;

import com.esprit.dari.entities.Notification;
import com.esprit.dari.entities.UserDari;

import com.esprit.dari.entities.NotificationType;


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
