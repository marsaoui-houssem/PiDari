package com.esprit.dari.controller.furnituresController;

import com.esprit.dari.services.furnituresServices.ITransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/furnitures")
public class TransporterRestController {

    @Autowired
    ITransporterService iTransporterService;


    @PostMapping("/validerTransporter/{commandId}/{transporterId}")
    @ResponseBody
    public void validerTransporter(@PathVariable("commandId")Long commandId,@PathVariable("transporterId") Long transporterId){
        iTransporterService.changeCommandEtatAndTransporter(commandId,transporterId);
    }
}
