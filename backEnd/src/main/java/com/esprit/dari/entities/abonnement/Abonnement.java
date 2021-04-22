package com.esprit.dari.entities.abonnement;



import com.esprit.dari.entities.userentity.UserDari;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbon ;

    private String nomAbon ;

    private String descriptionAbon ;

    @Enumerated(EnumType.STRING)
    private TypeAbon typeAbon ;

    private String dureAbonn;

    @Temporal(TemporalType.DATE)
    private Date DateDebut ;

    @Temporal(TemporalType.DATE)
    private Date Datefint;

    private float prix ;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "AssAbon" )
    private List<Assurence> Assurences = new ArrayList<>();


    @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "ServAbon" )
    @JsonIgnore
    private List<OffreService> Services = new ArrayList<>()  ;


    @ManyToOne(cascade=CascadeType.PERSIST)
    @JsonIgnore
    private UserDari userDariAbon ;


    public Abonnement(String nomAbon, String descriptionAbon, TypeAbon typeAbon, String dureAbonn, Date dateDebut, Date datefint, float prix) {
        this.nomAbon = nomAbon;
        this.descriptionAbon = descriptionAbon;
        this.typeAbon = typeAbon;
        this.dureAbonn = dureAbonn;
        DateDebut = dateDebut;
        Datefint = datefint;
        this.prix = prix;
    }


    public Abonnement(){
        super();
    }




    public int getIdAbon() {
        return idAbon;
    }

    public void setIdAbon(int idAbon) {
        this.idAbon = idAbon;
    }

    public String getNomAbon() {
        return nomAbon;
    }

    public void setNomAbon(String nomAbon) {
        this.nomAbon = nomAbon;
    }

    public String getDescriptionAbon() {
        return descriptionAbon;
    }

    public void setDescriptionAbon(String descriptionAbon) {
        this.descriptionAbon = descriptionAbon;
    }

    public TypeAbon getTypeAbon() {
        return typeAbon;
    }

    public void setTypeAbon(TypeAbon typeAbon) {
        this.typeAbon = typeAbon;
    }

    public String getDureAbonn() {
        return dureAbonn;
    }

    public void setDureAbonn(String dureAbonn) {
        this.dureAbonn = dureAbonn;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        DateDebut = dateDebut;
    }

    public Date getDatefint() {
        return Datefint;
    }

    public void setDatefint(Date datefint) {
        Datefint = datefint;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }


    public List<Assurence> getAssurences() {
        return Assurences;
    }

    public void setAssurences(List<Assurence> assurences) {
        Assurences = assurences;
    }

    public List<OffreService> getServices() {
        return Services;
    }

    public void setServices(List<OffreService> services) {
        Services = services;
    }

    public UserDari getUserDariAbon() {
        return userDariAbon;
    }

    public void setUserDariAbon(UserDari userDariAbon) {
        this.userDariAbon = userDariAbon;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "idAbon=" + idAbon +
                ", nomAbon='" + nomAbon + '\'' +
                ", descriptionAbon='" + descriptionAbon + '\'' +
                ", typeAbon=" + typeAbon +
                ", dureAbonn='" + dureAbonn + '\'' +
                ", DateDebut=" + DateDebut +
                ", Datefint=" + Datefint +
                ", prix=" + prix +
                ", Assurences=" + Assurences +
                ", Services=" + Services +
                '}';
    }
}
