package com.esprit.dari.controller.furnituresController;

import com.esprit.dari.entities.furnituresEntities.Furniture;
import com.esprit.dari.entities.furnituresEntities.Transportor;
import com.esprit.dari.services.furnituresServices.ITransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/furnitures")
public class TransporterRestController {

    @Autowired
    ITransporterService iTransporterService;


    @PostMapping("/addTransporter")
    @ResponseBody
    public Long addFurniture(@RequestBody Transportor transportor){
        iTransporterService.ajouterTransportor(transportor);
        return transportor.getTransporterId();
    }

    @DeleteMapping("/deleteTransporter/{transporterId}")
    @ResponseBody
    public void deleteTransporter(@PathVariable("transporterId") Long TransportorId){
        iTransporterService.deleteTransportorById(TransportorId);
    }


    @PostMapping("/validerTransporter/{commandId}/{transporterId}")
    @ResponseBody
    public void validerTransporter(@PathVariable("commandId")Long commandId,@PathVariable("transporterId") Long transporterId){
        iTransporterService.changeCommandEtatAndTransporter(commandId,transporterId);
    }

    @PutMapping("/modifierTransporter/{transporterId}")
    @ResponseBody
    public Long modifierTransporter(@PathVariable("transporterId") Long id,@RequestBody Transportor transporter){
        iTransporterService.modifiererTransportor(id,transporter);
        return transporter.getTransporterId();
    }

    @GetMapping(value = "/getTransporterById/{transportorId}")
    @ResponseBody
    public Transportor findTransportorById(@PathVariable("transportorId")Long id){
        return iTransporterService.getTransportorById(id);
    }
}
