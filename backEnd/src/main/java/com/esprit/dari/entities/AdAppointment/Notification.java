package com.esprit.dari.entities.AdAppointment;

import com.esprit.dari.entities.UserDari;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    @Enumerated(EnumType.STRING)
    private NotificationType notifType;
    private boolean isRead;

    @JsonIgnore
    @ManyToOne
    private UserDari user;

    @JsonIgnore
    @ManyToOne
    private Appointment appointment;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public NotificationType getNotifType() {
        return notifType;
    }

    public void setNotifType(NotificationType notifType) {
        this.notifType = notifType;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public UserDari getUser() {
        return user;
    }

    public void setUser(UserDari user) {
        this.user = user;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Notification(NotificationType notifType, UserDari user, Appointment appointment) {
        super();
        this.notifType = notifType;
        this.user = user;
        this.appointment = appointment;
        isRead=false;
    }
    public Notification() {
        super();
        // TODO Auto-generated constructor stub
    }
}