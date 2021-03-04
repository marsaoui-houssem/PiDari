package com.esprit.dari.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OffreService implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;

    private String nomServ ;

    private String descSer ;

    private  String dureService ;

    private float prixServ ;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private  Abonnement abonnement;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
