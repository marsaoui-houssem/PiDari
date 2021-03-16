package com.esprit.dari.entities;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


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



    @JsonIgnore
    @ManyToMany(mappedBy = "Assurences",fetch=FetchType.EAGER )
    private List<Abonnement> AssAbon ;




    public Assurence(String nomAssu, String descAssu, String dureAss, float prixAss , Date dateDebutAssu , Date dateFintAssu ) {
        this.nomAssu = nomAssu;
        this.descAssu = descAssu;
        this.dureAss = dureAss;
        this.prixAss = prixAss;
        this.dateDebutAssu = dateDebutAssu;
        this.dateFintAssu = dateFintAssu ;

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

    public List<Abonnement> getAssAbon() {
        return AssAbon;
    }

    public void setAssAbon(List<Abonnement> assAbon) {
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
