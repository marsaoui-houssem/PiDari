package com.esprit.dari.controller.abonnement;

import com.esprit.dari.entities.abonnement.Assurence;
import com.esprit.dari.services.abonnement.IAssurenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class IControllerAssurenceImpl {

    @Autowired
    IAssurenceService assuServ ;



    private List<Assurence> listAssu ;



    public int ajoutAssurence (Assurence asur){
        assuServ.ajoutAssurence(asur);
        return asur.getIdAssu() ;
    }


    public List<Assurence> getAllAssurence(){
        listAssu = assuServ.getAllAssurence();
        return listAssu;
    }



    public Assurence getByIdAssurence (int id )
    {
        return assuServ.getByIdAssurence(id);
    }



    public void deleteAssurence(int id ){

        assuServ.deleteAssurence(id);
    }

    public void affecteAssurAbonn ( int idAssu  ,  int idAbon){
        assuServ.affecteAssurAbonn(idAssu, idAbon);
    }

    public void desaffecterAssurenceDuAbon( int idAssu ){ assuServ.desaffecterAssurenceDuAbon(idAssu); }

    public float PrixAssurenceMulti (int idAssu , Long idAd ){
        return  assuServ.PrixAssurenceMulti(idAssu, idAd);
    }

    public void mettreAjourPrixAssurenceMulti (int idAssu , Long idAd  ){
        assuServ.mettreAjourPrixAssurenceMulti(idAssu, idAd);
    }

    public float PrixAssurenceMultiLoyerImp (int idAssu ,  Long idAd){
        return assuServ.PrixAssurenceMultiLoyerImp(idAssu,idAd);
    }
    public void mettreAjourPrixAssurenceMultiLoyerImp (int idAssu ,  Long idAd){
        assuServ.mettreAjourPrixAssurenceMultiLoyerImp(idAssu , idAd);
    }



/////////////////////////


    public List<Assurence> getListAssu() {
        return listAssu;
    }

    public void setListAssu(List<Assurence> listAssu) {
        this.listAssu = listAssu;
    }
}
