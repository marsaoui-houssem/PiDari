package com.eprit.dari.controller;

import com.eprit.dari.services.ITransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransporterRestController {

    @Autowired
    ITransporterService iTransporterService;


    @PostMapping("/addCommand/{commandId}/{transporterId}")
    @ResponseBody
    public void validerTransporter(@PathVariable("commandId")Long commandId,@PathVariable("transporterId") Long transporterId){
        iTransporterService.changeCommandEtatAndTransporter(commandId,transporterId);
    }
}
