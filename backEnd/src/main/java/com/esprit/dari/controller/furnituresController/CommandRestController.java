package com.esprit.dari.controller.furnituresController;

import com.esprit.dari.entities.furnituresEntities.Command;
import com.esprit.dari.services.furnituresServices.ICommandService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class CommandRestController {

    @Autowired
    ICommandService iCommandService;


    @PostMapping("/addCommand/{user}/{code}/{transporterValidation}")
    @ResponseBody
    public void addCommand(@PathVariable("user") Long user, @PathVariable("code")  String code,@PathVariable("transporterValidation")  Boolean transporterValidation) throws FileNotFoundException, DocumentException, MessagingException {
         iCommandService.ajouterCommand(user,code,transporterValidation);
    }


    @DeleteMapping("/deleteCommand/{commandId}")
    @ResponseBody
    public void deleteCommande(@PathVariable("commandId") Long commandId){
        iCommandService.deleteCommandById(commandId);
    }

    @GetMapping(value = "/getAllCommand")
    @ResponseBody
    public List<Command> findAllCommand(){return iCommandService.getAllCommand();}
}
