package com.esprit.dari.controller;

import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.services.IAssurenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public void affecteAssurAbonn (int idAbon, int idAssu  ){
        assuServ.affecteAssurAbonn(idAbon,idAssu);
    }


/////////////////////////


    public List<Assurence> getListAssu() {
        return listAssu;
    }

    public void setListAssu(List<Assurence> listAssu) {
        this.listAssu = listAssu;
    }
}
