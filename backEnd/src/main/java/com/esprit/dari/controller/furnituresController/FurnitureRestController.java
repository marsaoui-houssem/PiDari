package com.esprit.dari.controller.furnituresController;

import com.esprit.dari.entities.furnituresEntities.Furniture;
import com.esprit.dari.services.furnituresServices.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FurnitureRestController {

    @Autowired
    IFurnitureService iFurnitureService;


    @PostMapping("/addFurniture")
    @ResponseBody
    public Long addFurniture(@RequestBody Furniture furniture){
        iFurnitureService.ajouterFurniture(furniture);
        return furniture.getFurnitureId();
    }
    @DeleteMapping("/deleteFurniture/{furnitureId}")
    @ResponseBody
    public void deleteFurniture(@PathVariable("furnitureId") Long furnitureId){
        iFurnitureService.deleteFurnitureById(furnitureId);
    }

    @GetMapping(value = "/getAllCFurniture")
    @ResponseBody
    public List<Furniture> findFurnitures(){
        return iFurnitureService.getAllFurniture();
    }
}
