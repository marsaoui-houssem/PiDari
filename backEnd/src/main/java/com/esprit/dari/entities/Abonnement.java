package com.esprit.dari.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbon ;

    private String nomAbon ;

    private String descriptionAbon ;

    @Enumerated(EnumType.STRING)
    private Type typeAbon ;

    private String dureAbonn;

    @Temporal(TemporalType.DATE)
    private Date DateDebut ;

    @Temporal(TemporalType.DATE)
    private Date Datefint;

    private float prix ;

   @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "abonnement" ,fetch = FetchType.EAGER)
   private List<Assurence> assurences = new ArrayList<>();


    @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "abonnement")
    private List<OffreService> services = new ArrayList<>();


    public Abonnement(String nomAbon, String descriptionAbon, Type typeAbon, String dureAbonn, Date dateDebut, Date datefint, float prix) {
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
                ", assurences=" + assurences +
                ", services=" + services +
                '}';
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

    public Type getTypeAbon() {
        return typeAbon;
    }

    public void setTypeAbon(Type typeAbon) {
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
        return assurences;
    }

    public void setAssurences(List<Assurence> assurences) {
        this.assurences = assurences;
    }

    public List<OffreService> getServices() {
        return services;
    }

    public void setServices(List<OffreService> services) {
        this.services = services;
    }
}
