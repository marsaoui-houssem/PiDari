package com.esprit.dari.entities.abonnement;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Assurence implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAssu ;

    private String nomAssu ;
    private String descAssu ;
    private  String dureAss ;
    @Temporal(TemporalType.DATE)
    private Date dateDebutAssu ;
    @Temporal(TemporalType.DATE)
    private Date dateFintAssu ;
    private float prixAss ;
    @Enumerated(EnumType.STRING)
    private  TypeAssurence typeAssurence ;



    @JsonIgnore
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Abonnement  AssAbon ;


    public Assurence(String nomAssu, String descAssu, String dureAss, Date dateDebutAssu, Date dateFintAssu, float prixAss, TypeAssurence typeAssurence) {
        this.nomAssu = nomAssu;
        this.descAssu = descAssu;
        this.dureAss = dureAss;
        this.dateDebutAssu = dateDebutAssu;
        this.dateFintAssu = dateFintAssu;
        this.prixAss = prixAss;
        this.typeAssurence = typeAssurence;
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

    public Date getDateDebutAssu() {
        return dateDebutAssu;
    }

    public void setDateDebutAssu(Date dateDebutAssu) {
        this.dateDebutAssu = dateDebutAssu;
    }

    public Date getDateFintAssu() {
        return dateFintAssu;
    }

    public void setDateFintAssu(Date dateFintAssu) {
        this.dateFintAssu = dateFintAssu;
    }

    public TypeAssurence getTypeAssurence() {
        return typeAssurence;
    }

    public void setTypeAssurence(TypeAssurence typeAssurence) {
        this.typeAssurence = typeAssurence;
    }

    public Abonnement getAssAbon() {
        return AssAbon;
    }

    public void setAssAbon(Abonnement assAbon) {
        AssAbon = assAbon;
    }

    @Override
    public String toString() {
        return "Assurence{" +
                "idAssu=" + idAssu +
                ", nomAssu='" + nomAssu + '\'' +
                ", descAssu='" + descAssu + '\'' +
                ", dureAss='" + dureAss + '\'' +
                ", dateDebutAssu=" + dateDebutAssu +
                ", dateFintAssu=" + dateFintAssu +
                ", prixAss=" + prixAss +
                ", AssAbon=" + AssAbon +
                '}';
    }
}
