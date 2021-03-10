package com.esprit.dari;

import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.Type;
import com.esprit.dari.services.IAbonnementService;
import com.esprit.dari.services.IAssurenceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {

    @Autowired
    IAbonnementService abonserv ;


    @Autowired
    IAssurenceService assuserv ;


    @Test
    public void contextLoads()  throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date d = dateFormat.parse("2015-03-23");
        Date g = dateFormat.parse("2021-12-13");

      //  Abonnement abonnement = new Abonnement("nomAbon2","descriptionAbon2",Type.Premium,"dureAbonn2", d, g, 400);
      //  abonserv.ajoutAbonn(abonnement);


       // List<Abonnement> listabon= new ArrayList<Abonnement>();
       // listabon = abonserv.getAllAbon();

       // for(Abonnement i : listabon  ){
           //  System.out.println(i);
       // }

        //System.out.println(abonserv.getByIdAbonn(1));


      //  Assurence assur = new Assurence("nomAssu1", "descAssu1", "dureAss1", 200 );
      //  assuserv.ajoutAssurence(assur);
    }

}
