package com.esprit.dari.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
public class OffreService implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idServ ;

    private String nomServ ;

    private String descSer ;

    private  String dureService ;

    private float prixServ ;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private  Abonnement abonnement;

    public OffreService(String nomServ, String descSer, String dureService, float prixServ, Abonnement abonnement) {
        this.nomServ = nomServ;
        this.descSer = descSer;
        this.dureService = dureService;
        this.prixServ = prixServ;
        this.abonnement = abonnement;
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


    @Override
    public String toString() {
        return "Service{" +
                "idServ=" + idServ +
                ", nomServ='" + nomServ + '\'' +
                ", descSer='" + descSer + '\'' +
                ", dureService='" + dureService + '\'' +
                ", prixServ=" + prixServ +
                ", abonnement=" + abonnement +
                '}';
    }
}
