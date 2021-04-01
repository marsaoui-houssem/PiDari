package com.esprit.dari.entities.creditentitie;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double teaux;
    private double marge;
    private int ageMax;
    @Enumerated(EnumType.STRING)
    //@NotNull
    private Banque nomBanque;
    private double creditPotentielle;
    private double offre;
    private static double tmm = 5.23;
    private  String approuvation ="false";

    public Bank(int id, double teaux, double marge, int ageMax, Banque nomBanque, double creditPotentielle, double offre,String approuvation) {
        this.id = id;
        this.teaux = teaux;
        this.marge = marge;
        this.ageMax = ageMax;
        this.nomBanque = nomBanque;
        this.creditPotentielle = creditPotentielle;
        this.offre = offre;
        this.approuvation=approuvation;
    }


    public Bank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTeaux() {
        return teaux;
    }

    public void setTeaux(double teaux) {
        this.teaux = teaux;
    }

    public double getMarge() {
        return marge;
    }

    public void setMarge(double marge) {
        this.marge = marge;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public Banque getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(Banque nomBanque) {
        this.nomBanque = nomBanque;
    }

    public double getCreditPotentielle() {
        return creditPotentielle;
    }

    public void setCreditPotentielle(double creditPotentielle) {
        this.creditPotentielle = creditPotentielle;
    }

    public double getOffre() {
        return offre;
    }

    public void setOffre(double offre) {
        this.offre = offre;
    }

    public String getApprouvation() {
        return approuvation;
    }

    public void setApprouvation(String approuvation) {
        this.approuvation = approuvation;
    }


}
