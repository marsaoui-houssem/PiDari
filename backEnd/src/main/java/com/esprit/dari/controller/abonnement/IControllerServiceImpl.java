package com.esprit.dari.controller.abonnement;



import com.esprit.dari.entities.abonnement.OffreService;
import com.esprit.dari.services.abonnement.IServiceDeService;
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


    public void affecteServiceAabonn ( int idServ  , int idAbon ){
        serserv.affecteServiceAabonn(idServ,idAbon);
    }

    public List<OffreService> getListService() {
        return listService;
    }

    public void setListService(List<OffreService> listService) {
        this.listService = listService;
    }

    public float prixServiceMenagement (int idServ  , Long idAd    ){
        return serserv.prixServiceMenagement(idServ , idAd);
    }

    public void mettreAjourPrixService( int idServ , Long idAd ){
         serserv.mettreAjourPrixService(idServ,idAd);
    }
}
