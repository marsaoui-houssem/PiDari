package com.esprit.dari.services;



import com.esprit.dari.dao.IAbonnementRepository;
import com.esprit.dari.dao.IServiceRepository;
import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class ServiceDeServicempl  implements  IServiceDeService {

    @Autowired
    IServiceRepository serRep ;


    @Autowired
    IAbonnementRepository abonRep ;


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

        if (ab.getServices() == null ){

            List<OffreService> services = new ArrayList<>();
            services.add(serv);
            ab.setServices(services);
            abonRep.save(ab);
        }
        else {
            ab.getServices().add(serv);
            abonRep.save(ab);
        }

    }


}
