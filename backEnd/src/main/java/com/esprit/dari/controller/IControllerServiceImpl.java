package com.esprit.dari.controller;



import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.OffreService;
import com.esprit.dari.services.IServiceDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IControllerServiceImpl   {

    private List<OffreService> listService ;


    @Autowired
    IServiceDeService serserv ;



    public int  ajoutService( OffreService serv){
        serserv.ajoutService(serv);

        return serv.getIdServ();
    }


    public List<OffreService> getAllService(){
     listService = serserv.getAllService();
        return listService ;
    }



    public OffreService getByIdService (int id )
    {
        return serserv.getByIdService(id);
    }



    public void deleteService(int id ){
       serserv.deleteService(id);}


    public void affecteServiceAabonn ( int idAbon , int idServ){
     serserv.affecteServiceAabonn(idAbon ,idServ);

    }

    public List<OffreService> getListService() {
        return listService;
    }

    public void setListService(List<OffreService> listService) {
        this.listService = listService;
    }
}
