package com.esprit.dari;

import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.OffreService;
import com.esprit.dari.entities.Type;
import com.esprit.dari.services.IAbonnementService;
import com.esprit.dari.services.IAssurenceService;
import com.esprit.dari.services.IServiceDeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {

    @Autowired
    IAbonnementService abonserv;


    @Autowired
    IAssurenceService assuserv;

    @Autowired
    IServiceDeService servserv;


    @Test
    public void contextLoads() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("0000-00-00");
        Date g = dateFormat.parse("0000-00-00");

      // Abonnement abonnement1 = new Abonnement("dari server", " cette abonnement permetre a vous de consulter sur notre site darides assurence et de l'achete ", Type.Server, "un semestre ", d, g, 100);
      //Abonnement abonnement2 = new Abonnement("dari gold", "tu as la possibilitee de consulet et d'acheter nos assurence et des service limite ", Type.Gold, "une annee ", d, g, 200);
     // Abonnement abonnement3 = new Abonnement("dari premium", "c est notre meilleur abonnement cousluter et acheter tous notre assurences et service,nous affre des contrat gratuit et d'estimer votre bien et conntacter notre conseiller", Type.Premium, "une annee", d, g, 300);
     //  abonserv.ajoutAbonn(abonnement1);
     // abonserv.ajoutAbonn(abonnement2);
      // abonserv.ajoutAbonn(abonnement3);


        // List<Abonnement> listabon= new ArrayList<Abonnement>();
        // listabon = abonserv.getAllAbon();

        // for(Abonnement i : listabon  ){
        //  System.out.println(i);
        // }

        //System.out.println(abonserv.getByIdAbonn(1));


      // Assurence assur2 = new Assurence("assurence combriolages", " remboures en cas de vols ou de combriolages : protege tous les equipement et materiels presente dans l'abitatiosn", "une annee", 000,d,g );
      // Assurence assur3 = new Assurence("assurence loyer impayé", "en cas ou le buyer ne paye pas leur dete en rembourse nous meme  ", "dureAss1", 000,d,g );
      //  Assurence assur4 = new Assurence("assurence piscine", "en cas d'accident dans le piscine que ce soit matriele ou humaine en nous rembourse ", "dureAss1", 000 ,d,g);
      //  assuserv.ajoutAssurence(assur1);
     //   assuserv.ajoutAssurence(assur2);
     //   assuserv.ajoutAssurence(assur3);
     //   assuserv.ajoutAssurence(assur4);

      // OffreService serv1 = new OffreService("Service internet et tv ", "abonner vous a linternet et des chaines tv ,en vous intsale et en suivre si il ya des panne pendent tous une semestre ", "une semestre", 300,d,d);
       // OffreService serv2 = new OffreService("Service ménage   ", "une foit par semaine nous onvoyer notre equipe pour menage votre bien  ", "une semestre", 300,d,d);
       // OffreService serv3 = new OffreService("Service bricolage ", " a chaque que vous trouver une panne vous me contacter  ", "une semestre", 300,d,d);
       // OffreService serv4 = new OffreService("Service   ", "", "une semestre", 300,d,d);
      // servserv.ajoutService(serv1);
       // servserv.ajoutService(serv2);
       // servserv.ajoutService(serv3);
      // servserv.ajoutService(serv4);




        //assuserv.affecteAssurAbonn(1,1);

        List<Assurence> listas = new ArrayList<Assurence>();
                listas = abonserv.getAllAssubyAbon(1);

                for(Assurence s : listas ){
                    System.out.println(s);
                }
    }
}
