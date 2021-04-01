package com.esprit.dari.entities;

public enum EmailType {
    PASSWORD("resetpassword","rest password", 1000),
    CONFIRAMTION("confiramtionaccount","comfirm account", 10000);

    private final String path;
    private final String subject;
    private final long expirationTokenTime;

    EmailType(String path, String subject, long expirationTokenTime) {
        this.path =path;
        this.subject =subject;
        this.expirationTokenTime =expirationTokenTime;
    }

    public String getPath(){
        return path;
    }
    public String getSubject(){
        return subject;
    }
    public Long getExpirationTokenTime(){
        return expirationTokenTime;
    }
}
