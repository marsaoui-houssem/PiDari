package com.esprit.dari.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Ads implements Serializable {
    @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String Title;

    @Column
    private String Description;

    @Column
    private Date dateOfPost;

    @Column
    private String typeOfAd;

    public Ads() {
    }

    public Ads(Long id, String title, String description, Date dateOfPost, String typeOfAd) {
        Id = id;
        Title = title;
        Description = description;
        this.dateOfPost = dateOfPost;
        this.typeOfAd = typeOfAd;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public String getTypeOfAd() {
        return typeOfAd;
    }

    public void setTypeOfAd(String typeOfAd) {
        this.typeOfAd = typeOfAd;
    }

    @Override
    public String toString() {
        return "ads{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", dateOfPost=" + dateOfPost +
                ", typeOfAd='" + typeOfAd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return Id.equals(ads.Id) && Objects.equals(Title, ads.Title) && Objects.equals(Description, ads.Description) && Objects.equals(dateOfPost, ads.dateOfPost) && Objects.equals(typeOfAd, ads.typeOfAd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Title, Description, dateOfPost, typeOfAd);
    }
}
