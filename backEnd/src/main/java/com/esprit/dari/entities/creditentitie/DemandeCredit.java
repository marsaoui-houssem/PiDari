package com.esprit.dari.entities.creditentitie;



import com.esprit.dari.entities.userentity.UserDari;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DemandeCredit implements Serializable {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private  int id;
private double salaire;
private  double montantDemandé;
private int durée;
private int age;
    @Enumerated(EnumType.STRING)
    //@NotNull
    private Profession profession;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private  UserDari userDari;

    public DemandeCredit(double salaire, double montantDemandé, int durée, int age, Profession profession, UserDari userDari) {
        this.salaire = salaire;
        this.montantDemandé = montantDemandé;
        this.durée = durée;
        this.age = age;
        this.profession = profession;
        this.userDari = userDari;
    }

    public DemandeCredit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public double getMontantDemandé() {
        return montantDemandé;
    }

    public void setMontantDemandé(double montantDemandé) {
        this.montantDemandé = montantDemandé;
    }

    public int getDurée() {
        return durée;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public UserDari getUserDari() {
        return userDari;
    }

    public void setUserDari(UserDari userDari) {
        this.userDari = userDari;
    }
}
