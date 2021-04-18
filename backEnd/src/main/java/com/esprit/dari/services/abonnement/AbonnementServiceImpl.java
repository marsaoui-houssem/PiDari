package com.esprit.dari.services.abonnement;

import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.abonnement.*;


import com.esprit.dari.dao.userrepository.UserDariRepository;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdType;
import com.esprit.dari.entities.AdAppointment.Ad_Etat;
import com.esprit.dari.entities.abonnement.*;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Calendar;
import java.util.Date;

import java.util.List;



@Service
public class AbonnementServiceImpl implements IAbonnementService {

    @Autowired
    IAbonnementRepository abonRep;

    @Autowired
    IAssurenceRepository assRep ;

    @Autowired
    IServiceRepository servRep ;

    @Autowired
    UserDariRepository userRep ;

    @Autowired
    AdRepository adRep ;

    @Autowired
    private EmailSenderService service ;


    @Override
    public int ajoutAbonn(Abonnement abon) {
        abonRep.save(abon);
        return abon.getIdAbon();
    }

    @Override
    public List<Abonnement> getAllAbon() {

        return (List<Abonnement>) abonRep.findAll();
    }
    @Override
    public Abonnement getByIdAbonn(int id) {
        return abonRep.findById(id).get();
    }


    @Override
    public void deleteAbonn(int id) {
        Abonnement abonn = abonRep.findById(id).orElse(null);
        abonRep.delete(abonn);
    }

    @Override
    public void affecteruserAabon (Long userId , int idAbon ){

        Abonnement abon = abonRep.findById(idAbon).orElse(null);
        UserDari user = userRep.findById(userId).orElse(null);
        abon.setUserDariAbon(user);
        abonRep.save(abon);


    }

    @Override
    public List<Assurence> getAllAssubyAbon (int idAbon ){ return  assRep.getAllAssubyAbon(idAbon);
    }
    @Override
    public List<OffreService> getAllServbyAbon (int idAbon){
        return servRep.getAllServbyAbon(idAbon);
    }

    @Override
    public List<Date > getAllDatefint (){return abonRep.getAllDatefint();  }

    @Override
    public void mettreAjourdatefinByAbon(Date datefint , int idAbon ){
        abonRep.mettreAjourdatefinByAbon(datefint,idAbon);}

    @Override
    public int countAbonserver (){
        return abonRep.countAbonserver();
    }
    @Override
    public int countAbonGold(){
        return abonRep.countAbonGold();
    }
    @Override
    public int ContAbonPremium(){
        return abonRep.ContAbonPremium();
    }

    @Override
    public String meilleurVenteAbon(){
        String info = null;

              int sommServer =  countAbonserver() ;
              int sommeGold  =  countAbonGold();
              int sommePremium = ContAbonPremium();

              if ( (sommServer > sommeGold) && (sommServer > sommePremium ) ){
                  info =" le meilleur vente d'abonnement est server  ";
              }
              else if ( (sommeGold > sommServer) && (sommeGold > sommePremium ) ){
                   info = " le meilleur vente d'abonnement est Gold  ";
              }
                  else if ( (sommePremium > sommServer) && ( sommePremium > sommeGold  ) ){
                        info =" le meilleur vente d'abonnement est Premium   ";
                       }

          return info ;
    }




    @Override
    public String CaracteristiqueAbonne (int idAbon ){
          String information = null ;

          Abonnement ab = abonRep.findById(idAbon).get();
            TypeAbon type  = ab.getTypeAbon() ;
            System.out.println(type);

             if(type == TypeAbon.Server ){
                 information = " tu as la possibiliter d'acheter l'assurence Combriolages et le service internetTv ";
             }
             if(type == TypeAbon.Gold ){
                 information = "tu as la possibliter d'achter nos assurence (Combriolages , Loyer Impeye ) et nos services ( internettv , transpotImobilier , menagement )";
             }
             if(type == TypeAbon.Premium){
                 information =" tu as le tous (multirisque , loyerImpaye, combriolages ) et (internettv menegement bricolage Transport Imobilier)";
             }


        return information ;
    }



    @Override
    //@EventListener(ApplicationReadyEvent.class)
    public void alerFintAbonnement (){

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int monthToDay = localDate.getMonthValue();
        int anneToDay = localDate.getYear();
        //System.out.println(monthToDay);
       // System.out.println(anneToDay);



        List<Abonnement>  listAbon =  getAllAbon();
       for(Abonnement ab : listAbon  ){
             Date dateAbon = ab.getDatefint();
             UserDari  userDariAbon = ab.getUserDariAbon();

               Calendar cal = Calendar.getInstance();
               cal.setTime(dateAbon);
               int monthAbon = cal.get(Calendar.MONTH)+1;
               int anneAbon = cal.get(Calendar.YEAR);
               //  System.out.println(monthAbon);
              // System.out.println(anneAbon);
              if ((anneToDay == anneAbon) && ( monthToDay-1 == monthAbon) ){
                  System.out.println("cette abonnement apre un mois va termine "+ ab.getIdAbon());
                  System.out.println(userDariAbon.getUsername());

                    service.sendSimpleEmail( "saifhenchir@gmail.com" ,
                   " votre abbonnement "+ab.getNomAbon() +" ca sera  désactivé apres un moi Monsieur/Madame :  "+userDariAbon.getUsername() ,
                   " allert de site dari "  );

              }
        }
    }





     @Override
     public  float  prixAbonRemise (int id) {
        Abonnement abon = abonRep.findById(id).orElse(null);
         float prixtotle = 0;
         float sommeassu = 0;
         float sommeserv = 0;
         List<Assurence> Assurences = getAllAssubyAbon(id);
         List<OffreService> Services = getAllServbyAbon(id);


         if (abon.getTypeAbon() == TypeAbon.Premium) {

             for (Assurence as : Assurences) {
                 sommeassu = sommeassu + as.getPrixAss() ;
             }
             for (OffreService of : Services) {
                 sommeserv =  sommeserv + of.getPrixServ()  ;
             }

             prixtotle = ((sommeassu + sommeserv + abon.getPrix()) * 30) / 100;

         } else {
             System.out.println("cette abonnement n est pas un remise");
         }
         return prixtotle;
     }


     @Override
     public void mettreAjourPrixRemise( int id ){
       float prix = prixAbonRemise(id);
         abonRep.mettreAjourPrixRemise(id , prix );
     }


     @Override
     public List<Ad> getAllAdByuser(Long userId){
        return adRep.getAllAdByuser(userId);
     }


     @Override
     public  String conseilleAchatAbon(Long userId){

         String Conseille = null;
         int  nombreApp = 0 ;
         int nombreVilla = 0 ;
         int nombreMaisonHaute = 0 ;
         boolean forRent = false ;
         UserDari user = userRep.findById(userId).get();


         List<Ad>  ad =  adRep.getAllAdByuser(userId);
         for(Ad A : ad ){
             System.out.println(A.toString());

             if (A.getType() == AdType.appartement){ nombreApp= nombreApp+1 ;}
             if (A.getType() == AdType.Villa ) {nombreVilla= nombreVilla+1 ;  }
             if(A.getType() == AdType.maison_hote ){nombreMaisonHaute = nombreMaisonHaute+1 ; }
             if(A.getEtat() == Ad_Etat.For_Rent ){ forRent = true ;  }
         }

         System.out.println(nombreApp);
         System.out.println(nombreVilla);
         System.out.println((nombreMaisonHaute));
                 if( (nombreMaisonHaute != 0 ) && ( nombreVilla != 0 ) && (nombreApp != 0  )){
                     Conseille = "je vous conseille d'acheter abonnement premium ";}
                 if(  (nombreVilla >= 1 ) && ( nombreMaisonHaute == 0) && (nombreApp !=0  ) && (forRent = true ) ) {
                     Conseille = " je vous conseille d acheter abonnement gold " ;
                 }
                 if( (nombreMaisonHaute == 0 ) && ( nombreVilla == 0 ) && ( nombreApp != 0 ) ){
                     Conseille = "je vous conseille d'acheter abonnement Server" ;
                 }

         return Conseille ;
     }




}
