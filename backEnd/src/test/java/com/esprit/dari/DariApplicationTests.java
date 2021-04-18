package com.esprit.dari;

import com.esprit.dari.dao.abonnement.IAbonnementRepository;
import com.esprit.dari.entities.abonnement.*;
import com.esprit.dari.services.abonnement.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {

    @Autowired
    IAbonnementService abonserv;


    @Autowired
    IAssurenceService assuserv;

    @Autowired
    IServiceDeService servserv;




    @Autowired
    IAbonnementRepository abonRep ;



    @Test
    public void contextLoads() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("2020-12-12");
        Date g = dateFormat.parse("2020-03-06");
        Date c = dateFormat.parse("2021-1-08");

        // Abonnement abonnement1 = new Abonnement("dari server", " cette abonnement permetre a vous de consulter sur notre site darides assurence et de l'achete ", TypeAbon.Server, "un semestre ", d, g, 110);
        // Abonnement abonnement2 = new Abonnement("dari gold", "tu as la possibilitee de consulet et d'acheter nos assurence et des service limite ", TypeAbon.Gold, "une annee ", d, g, 250);
        // Abonnement abonnement3 = new Abonnement("dari premium", "c est notre meilleur abonnement cousluter et acheter tous notre assurences et service,nous affre des contrat gratuit et d'estimer votre bien et conntacter notre conseiller", TypeAbon.Premium, "une annee", d, c, 330);
        //  abonserv.ajoutAbonn(abonnement1);
       // abonserv.ajoutAbonn(abonnement2);
        //  abonserv.ajoutAbonn(abonnement3);


        // List<Abonnement> listabon= new ArrayList<Abonnement>();
        // listabon = abonserv.getAllAbon();

        // for(Abonnement i : listabon  ){
        //  System.out.println(i);
        // }

        //System.out.println(abonserv.getByIdAbonn(1));


         Assurence assur2 = new Assurence("assurence combriolages", " remboures en cas de vols ou de combriolages : protege tous les equipement et materiels presente dans l'abitatiosn", "une annee",d,g,0 , TypeAssurence.Combriolages );
         Assurence assur3 = new Assurence("assurence loyer impayé", "en cas ou le buyer ne paye pas leur dete en rembourse nous meme  ", "dureAss1",d,g , 0, TypeAssurence.LoyerImpaye);
         Assurence assur4 = new Assurence("assurence Multirisque ", " assurence multirisue qui vous rembourser dans tous les cas des accidents   ", "dureAss1",d,g , 0 , TypeAssurence.Multirisque);

          assuserv.ajoutAssurence(assur2);
          assuserv.ajoutAssurence(assur3);
         assuserv.ajoutAssurence(assur4);

         //OffreService serv1 = new OffreService("Service internet et tv ", "abonner vous a linternet et des chaines tv ,en vous intsale et en suivre si il ya des panne pendent tous une semestre ", "une semestre", 80,d,d , TypeService.InternetTv);
         //OffreService serv2 = new OffreService("Service ménagement   ", "une foit par semaine nous onvoyer notre equipe pour menage votre bien  ", "une semestre", 50,d,d, TypeService.Menagement);
        //  OffreService serv3 = new OffreService("Service bricolage ", " a chaque que vous trouver une panne vous me contacter  ", "une semestre", 100,d,d , TypeService.Bricolage);
         //OffreService serv4 = new OffreService("Service transport imeuble  ", "vous voulez changer votre maison , nous servirons des camions pour votre transport imobilier ", "une semestre", 200,d,d , TypeService.TransportImobilier);
         // servserv.ajoutService(serv1);
         // servserv.ajoutService(serv2);
         // servserv.ajoutService(serv3);
        // servserv.ajoutService(serv4);




        // assuserv.affecteAssurAbonn(2,3);

        // List<Assurence> listas = new ArrayList<Assurence>();
        //    listas = abonserv.getAllAssubyAbon(1);

        //   for(Assurence s : listas ){
        //   System.out.println(s);
        //  }


        //UserDari user = new  UserDari( "sarhan", "123456789");
        //userserv.ajoutUser(user);
        // UserDari user1 = new  UserDari( "chakib ben salah ", "chakib");
        // userserv.ajoutUser(user1);

        // System.out.println (abonserv.prixAbonRemise(3));
///////////////////////////////////
        //  float somme = 0 ;
        // Abonnement abon = abonRep.findById(3).orElse(null);
        ///  List<OffreService> services = new ArrayList<>();
        //        services = abon.getServices();

        //     List<Float> prixs = new ArrayList<Float>();

        //  for (OffreService of : services ){
        //     prixs.add(of.getPrixServ());
        //      }

        // System.out.println(prixs);
////////////////////////////////////////////////

        //System.out.println( abonserv.sommeServ(3));
        // System.out.println(abonserv.prixAbonRemise(1));


        //  Ad  ad = new Ad("appartement a vendre  ", 900000 , 0, "carthage", 800, 8, 9, true, "appartement ", Ad_Etat.For_Sell, AdType.appartement);
        //  adserv.ajouteAd(ad);

        // Ad ad1 = new Ad(" a vendre villa a sokra ", 600000, 0, "sokra", 500, 9  , 5, true, "villa a sokra", Ad_Etat.For_Sell, AdType.Villa);
        //  adserv.ajouteAd(ad1);
        // Ad ad2 = new Ad(" appartement s+3  ",0 , 450000, "la goulette", 300, 6  , 3, false, "appartement a la goulette", Ad_Etat.For_Rent, AdType.appartement);
        // adserv.ajouteAd(ad2);
        // Ad ad3 = new Ad(" appartement a vendre a bardo  ",500000 , 0, "bardo", 550, 6  , 4, false, "a vendre appartement ", Ad_Etat.For_Sell, AdType.appartement);
        // adserv.ajouteAd(ad3);


        //adserv.affecteAdAUser(6,3);
        //adserv.affecteAdAUser(2,2);
        // adserv.affecteAdAUser(4,2);
        //System.out.println(abonserv.conseilleAchatAbon(1));




        //userserv.affecteruserAabon(3,1);

        //abonserv.alerFintAbonnement();
        //abonserv.CaracteristiqueAbonne(1 );

        //abonserv.mettreAjourdatefinByAbon(c,1);
        //System.out.println(abonserv.countAbonserver());
        // System.out.println(abonserv.meilleurVenteAbon());
        // assuserv.desaffecterAssurenceDuAbon(3);


    }
}
