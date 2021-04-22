package com.esprit.dari.entities.abonnement;


import com.fasterxml.jackson.annotation.*;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class OffreService implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idServ ;

    private String nomServ ;

    private String descSer ;

    private  String dureService ;

    private float prixServ ;
    @Temporal(TemporalType.DATE)
    private Date datedebutService ;
    @Temporal(TemporalType.DATE)
    private Date dateFintService ;

    @Enumerated(EnumType.STRING)
    private TypeService typeservice ;



    @JsonIgnore
    @ManyToOne(cascade=CascadeType.PERSIST)
    private  Abonnement ServAbon ;


    public OffreService(String nomServ, String descSer, String dureService, float prixServ, Date datedebutService, Date dateFintService, TypeService typeservice) {
        this.nomServ = nomServ;
        this.descSer = descSer;
        this.dureService = dureService;
        this.prixServ = prixServ;
        this.datedebutService = datedebutService;
        this.dateFintService = dateFintService;
        this.typeservice = typeservice;
    }

    public OffreService(){
        super();
    }


    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }

    public String getNomServ() {
        return nomServ;
    }

    public void setNomServ(String nomServ) {
        this.nomServ = nomServ;
    }

    public String getDescSer() {
        return descSer;
    }

    public void setDescSer(String descSer) {
        this.descSer = descSer;
    }

    public String getDureService() {
        return dureService;
    }

    public void setDureService(String dureService) {
        this.dureService = dureService;
    }

    public float getPrixServ() {
        return prixServ;
    }

    public void setPrixServ(float prixServ) {
        this.prixServ = prixServ;
    }


    public Date getDatedebutService() {
        return datedebutService;
    }

    public void setDatedebutService(Date datedebutService) {
        this.datedebutService = datedebutService;
    }

    public Date getDateFintService() {
        return dateFintService;
    }

    public void setDateFintService(Date dateFintService) {
        this.dateFintService = dateFintService;
    }

    public TypeService getTypeservice() {
        return typeservice;
    }

    public void setTypeservice(TypeService typeservice) {
        this.typeservice = typeservice;
    }

    public Abonnement getServAbon() {
        return ServAbon;
    }

    public void setServAbon(Abonnement servAbon) {
        ServAbon = servAbon;
    }

    @Override
    public String toString() {
        return "OffreService{" +
                "idServ=" + idServ +
                ", nomServ='" + nomServ + '\'' +
                ", descSer='" + descSer + '\'' +
                ", dureService='" + dureService + '\'' +
                ", prixServ=" + prixServ +
                ", datedebutService=" + datedebutService +
                ", dateFintService=" + dateFintService +
                ", ServAbon=" + ServAbon +
                '}';
    }
}
