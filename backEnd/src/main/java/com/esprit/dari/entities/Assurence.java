package com.esprit.dari.entities;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
public class Assurence implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAssu ;

    private String nomAssu ;
    private String descAssu ;
    private  String dureAss ;
    private float prixAss ;
    @ManyToOne(cascade = CascadeType.PERSIST)
     private Abonnement abonnement;






    public Assurence(String nomAssu, String descAssu, String dureAss, float prixAss) {
        this.nomAssu = nomAssu;
        this.descAssu = descAssu;
        this.dureAss = dureAss;
        this.prixAss = prixAss;

    }


    public Assurence(){
        super();
    }


    public int getIdAssu() {
        return idAssu;
    }

    public void setIdAssu(int idAssu) {
        this.idAssu = idAssu;
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


    @Override
    public String toString() {
        return "Assurence{" +
                "idAssu=" + idAssu +
                ", nomAssu='" + nomAssu + '\'' +
                ", descAssu='" + descAssu + '\'' +
                ", dureAss='" + dureAss + '\'' +
                ", prixAss=" + prixAss +
                ", abonnement=" + abonnement +
                '}';
    }
}
