package com.esprit.dari.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.service.RentAdService;
import tn.esprit.spring.service.SellContractService;
import tn.esprit.spring.service.SellService;


@Controller
public class ControllerSaleAdimpl {

	@Autowired
    SellService Sell;

	
	@Autowired
	SellContractService SellC;
    
    @PostMapping(value="/AddBid/{idAd}/{idUser}/{Price}")
    @ResponseBody
	public void AddBid(@PathVariable("idAd")int idAd,@PathVariable("idUser")int idUser,@PathVariable("Price")int Price){
		
		Sell.AddBid(idAd,idUser,Price);
    	
	}
	
    @DeleteMapping(value="/deleteId/{idAd}")
    @ResponseBody
    public void DeleteSellAd(@PathVariable("i")int i){
    	 Sell.DeleteSellAd(i);
    }
	
	

	@PostMapping(value="/AddSellContract/{OwnerIdentityCard}/{RenterIdentityCard}/{ficheDePaie}/{EngagementLetter}/{Rentid}")
	@ResponseBody
	public void AddSellContract(@PathVariable("OwnerIdentityCard")String OwnerIdentityCard,@PathVariable("RenterIdentityCard")String RenterIdentityCard,@PathVariable("ficheDePaie")String ficheDePaie,@PathVariable("EngagementLetter")String EngagementLetter,@PathVariable("Rentid")int Sellid)
	{
		SellC.AddSellContract(OwnerIdentityCard,RenterIdentityCard,ficheDePaie,EngagementLetter,Sellid);
    }
	
}
