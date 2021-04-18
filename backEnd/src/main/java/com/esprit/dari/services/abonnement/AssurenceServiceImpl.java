package com.esprit.dari.services.abonnement;


import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.abonnement.IAbonnementRepository;

import com.esprit.dari.dao.abonnement.IAssurenceRepository;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.Ad_Etat;
import com.esprit.dari.entities.abonnement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class AssurenceServiceImpl implements IAssurenceService {


    @Autowired
    IAssurenceRepository assRep ;


    @Autowired
    IAbonnementRepository abonRep ;


    @Autowired
    AdRepository adRep ;

    @Override
    public int ajoutAssurence (Assurence asur){
        assRep.save(asur);
        return asur.getIdAssu() ;
    }

    @Override
    public List<Assurence> getAllAssurence(){

        return (List<Assurence>)  assRep.findAll();
    }


    @Override
    public Assurence getByIdAssurence (int id ){
        return assRep.findById(id).get();
    }


    @Override
    public void deleteAssurence(int id ){
        Assurence assu = assRep.findById(id).orElse(null);
        assRep.delete(assu);


    }

     @Override
     public void affecteAssurAbonn ( int idAssu  ,  int idAbon) {

         Assurence ass = assRep.findById(idAssu).get();
         Abonnement abon = abonRep.findById(idAbon).get();

                 ass.setAssAbon(abon);
                 assRep.save(ass);


       // if (abon.getAssurences() == null ){

         //   List<Assurence> assuren = new ArrayList<>();
          //  assuren.add(ass);
         //   abon.setAssurences(assuren);
         //   abonRep.save(abon);
       // }
       // else {
         //   abon.getAssurences().add(ass);
          //  abonRep.save(abon);
       // }

    }
    @Override
    public void desaffecterAssurenceDuAbon( int idAssu ){

        Assurence ass = assRep.findById(idAssu).orElse(null);
        ass.setAssAbon(null)  ;
            assRep.save(ass);
    }



    @Override
    public float PrixAssurenceMulti (int idAssu , Long idAd   ){

        float prix = 0 ;
        Assurence assurence = assRep.findById(idAssu).orElse(null);

        Ad ad =  adRep.findById(idAd).orElse(null);
        double surface = ad.getSurface();

        if (assurence.getTypeAssurence() == TypeAssurence.Multirisque ) {


            if ((surface > 1) && (surface <= 50)) {
                prix = 100;
            } else if ((surface >= 51) && (surface <= 100)) {
                prix = 200;
            } else if ((surface >= 101) && (surface <= 300)) {
                prix = 350;
            } else if ((surface >= 301) && (surface <= 500)) {
                prix = 400;
            } else prix = 500;




        }
        return prix ;
    }
    @Override
    public void mettreAjourPrixAssurenceMulti (int idAssu , Long idAd  ){
         float prix = PrixAssurenceMulti(idAssu , idAd  );
        assRep.modifprix(idAssu, prix);
    }



    @Override
    public float PrixAssurenceMultiLoyerImp (int idAssu , Long idAd){

       float prix = 0 ;
        Assurence assurence = assRep.findById(idAssu).orElse(null);

           Ad ad = adRep.findById(idAd).orElse(null);
              double prixRent = ad.getPriceRent();

              double prixrentAnnuel = prixRent * 12 ;

           if  ((ad.getEtat() == Ad_Etat.For_Rent )&&(assurence.getTypeAssurence() == TypeAssurence.LoyerImpaye)){

                 prix = (float) (( prixrentAnnuel * 3 )/ 100);


           }

      return prix ;
    }
    @Override
    public void mettreAjourPrixAssurenceMultiLoyerImp (int idAssu , Long idAd){
        float prix = PrixAssurenceMultiLoyerImp ( idAssu , idAd);
        assRep.modifprix(idAssu, prix);
    }


    //public void mettreAjourPrixAssurenceCombriolage (int idAssu ,  int id){
    //  hne bech nehseb 9ade mn imeuble tesra9 w nehseb 9adech ta3widh

}
