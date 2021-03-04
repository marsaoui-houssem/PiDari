package com.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Assurence implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String nomAssu ;
    private String descAssu ;
    private  String dureAss ;
    private float prixAss ;
    @ManyToOne(cascade = CascadeType.PERSIST)
     private Abonnement abonnement;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAssu() {
        return nomAssu;
    }

    public void setNomAssu(String nomAssu) {
        this.nomAssu = nomAssu;
    }

    public String getDescAssu() {
        return descAssu;
    }

    public void setDescAssu(String descAssu) {
        this.descAssu = descAssu;
    }

    public String getDureAss() {
        return dureAss;
    }

    public void setDureAss(String dureAss) {
        this.dureAss = dureAss;
    }

    public float getPrixAss() {
        return prixAss;
    }

    public void setPrixAss(float prixAss) {
        this.prixAss = prixAss;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
}
