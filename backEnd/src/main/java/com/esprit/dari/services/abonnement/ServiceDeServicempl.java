package com.esprit.dari.services.abonnement;



import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.abonnement.IAbonnementRepository;

import com.esprit.dari.dao.abonnement.IServiceRepository;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdType;
import com.esprit.dari.entities.abonnement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ServiceDeServicempl  implements  IServiceDeService {

    @Autowired
    IServiceRepository serRep ;


    @Autowired
    IAbonnementRepository abonRep ;

    @Autowired
    AdRepository adRep ;


    @Override
    public int  ajoutService( OffreService serv){
        serRep.save(serv);

        return serv.getIdServ();
    }

    @Override
    public List<OffreService> getAllService(){

        return (List<OffreService>) serRep.findAll();
    }


    @Override
    public OffreService getByIdService (int id )
    {
        return serRep.findById(id).get();
    }


    @Override
    public void deleteService(int id ){
        OffreService serv = serRep.findById(id).orElse(null);
        serRep.delete(serv);


    }

    @Override
    public void affecteServiceAabonn ( int idServ  , int idAbon ){

         OffreService serv =  serRep.findById(idServ).get();
         Abonnement ab = abonRep.findById(idAbon).get();

         serv.setServAbon(ab);
         serRep.save(serv);

        //if (ab.getServices() == null ){

           // List<OffreService> services = new ArrayList<>();
          //  services.add(serv);
          //  ab.setServices(services);
          //  abonRep.save(ab);
       // }
       // else {
        //    ab.getServices().add(serv);
        //    abonRep.save(ab);
        //}

    }


     @Override
     public float prixServiceMenagement (int idServ  , Long idAd     ){
        float prix = 0 ;

        OffreService service = serRep.findById(idServ).orElse(null);
         Ad ad =  adRep.findById(idAd).orElse(null);
                if(service.getTypeservice() == TypeService.Menagement ){

                    float  prixRoom = ad.getRooms()* 20000 ;
                       if (ad.getType() == AdType.appartement){
                           prix = prixRoom + ((prixRoom*10)/100);

                       }
                       if(ad.getType() == AdType.Villa){

                          prix = prixRoom + ((prixRoom*15)/100);
                       }
                       if( ad.getType() == AdType.maison_hote  ){
                           prix = prixRoom + ((prixRoom*20)/100);
                       }


                }
        return prix ;
     }




     @Override
     public void mettreAjourPrixService( int idServ , Long idAd ){
       float  prix = prixServiceMenagement(idServ, idAd);
         serRep.mettreAjourPrixService(idServ , prix );
     }





   // transport imobilier mazelet


}
