package com.eprit.dari.services;

import com.eprit.dari.dao.CommandRepository;
import com.eprit.dari.dao.TransporterRepository;
import com.eprit.dari.entities.Command;
import com.eprit.dari.entities.Transportor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import java.util.List;
import java.util.Objects;

@Service
public class TransporterServiceImpl implements ITransporterService{

    @Autowired
    TransporterRepository transporterRepository;
    @Autowired
    CommandRepository commandRepository;

    @Value("${app.twillio.accountSID}")
    private String ACCOUNT_SID;

    @Value("${app.twillio.authToken}")
    private String AUTH_TOKEN;


    @Override
    public Long ajouterCommand(Transportor transportor) {
        transporterRepository.save(transportor);
        return transportor.getTransporterId();
    }

    @Override
    public void deleteCommandById(Long transportorId) {
        transporterRepository.deleteById(transportorId);
    }

    @Override
    public List<Transportor> getAllCommand() {
        return (List<Transportor>) transporterRepository.findAll();
    }

    @Override
    public void affecterTransporterToCommand(Long transportorId, Long commandId) {
        Transportor transportor = transporterRepository.findById(transportorId).get();
        Command command = commandRepository.findById(commandId).get();
        if (command.getUsers().getVille() == transportor.getSecteur()){
            command.setTransporters(transportor);
            commandRepository.save(command);
        }else {
            System.out.println("il faut que le transporteur travail dans le meme ville du client !! ");
        }
    }


    @Override
    public void changeCommandEtatAndTransporter(Long commandId, Long transporterId) {
        Command command = commandRepository.findById(commandId).get();
        Transportor transportor = transporterRepository.findById(transporterId).get();
        String string1 = command.getUsers().getVille();
        String string2 = transportor.getSecteur();
        if (string1.equalsIgnoreCase(string2)){
            command.setTransporters(transportor);
            command.setEtat("Shipped");
            commandRepository.save(command);

            try {
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator( new PhoneNumber(command.getUsers().getPhoneNumber()), new PhoneNumber("+15046084562"),"body") // to:to which no  you want to send sms
                        .setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
                        .setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text message
                        .create();

                System.out.println(message);
                System.out.println(message.getSid());

            }catch(Exception e) {

                e.printStackTrace();

            }
        }else {
            System.out.println("il faut que le transporteur travail dans le meme ville du client !! ");
        }
    }
}
