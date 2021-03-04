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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

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








}
