package com.esprit.dari.entities;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    private Date datedebutService ;

    private Date dateFintService ;


    @JsonIgnore
    @ManyToMany(mappedBy = "Services",fetch=FetchType.EAGER )
    private List<Abonnement> ServAbon ;




    public OffreService(String nomServ, String descSer, String dureService, float prixServ,Date datedebutService,Date dateFintService) {
        this.nomServ = nomServ;
        this.descSer = descSer;
        this.dureService = dureService;
        this.prixServ = prixServ;
        this.datedebutService=datedebutService;
        this.dateFintService=dateFintService;
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

    public List<Abonnement> getServAbon() {
        return ServAbon;
    }

    public void setServAbon(List<Abonnement> servAbon) {
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
