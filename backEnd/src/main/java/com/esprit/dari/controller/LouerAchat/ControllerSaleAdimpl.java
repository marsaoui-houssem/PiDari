package com.esprit.dari.controller.LouerAchat;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import com.esprit.dari.entities.LouerAchat.SellContract;
import com.esprit.dari.services.LouerAchat.SellContractService;
import com.esprit.dari.services.LouerAchat.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ControllerSaleAdimpl {

	@Autowired
	SellService Sell;

	
	@Autowired
	SellContractService SellC;
    
	
	@GetMapping(value="GetAllSellContracts")
	@ResponseBody
	public List<SellContract> GetAllContracts(){return SellC.GetAllContracts();}
	
	
    @PostMapping(value="/AddBid/{idAd}/{idUser}/{Price}")
    @ResponseBody
	public void AddBid(@PathVariable("idAd")int idAd,@PathVariable("idUser")Long idUser,@PathVariable("Price")int Price){
		Sell.AddBid(idAd,idUser,Price);
	}
	
    
    @DeleteMapping(value="/deleteBidById/{idAd}")
    @ResponseBody
    public void DeleteSellAd(@PathVariable("idAd")int idAd){
    	 Sell.DeleteSellAd(idAd);
    }
	
    @DeleteMapping(value="/DeleteSellContractById/{ContractId}")
    @ResponseBody
    public void DeleteContractById(@PathVariable("ContractId")int ContractId){SellC.DeleteContractById(ContractId);}
    
    
    @GetMapping(value="/GetBidByAdId/{idAd}")
    @ResponseBody
    public void GetBidById(@PathVariable("idAd")int idAd){
    	Sell.GetBidByAdId(idAd);
    }
    
	@PostMapping(value="/AddSellContract/{OwnerIdentityCard}/{RenterIdentityCard}/{ficheDePaie}/{EngagementLetter}/{Rentid}")
	@ResponseBody
	public void AddSellContract(@PathVariable("OwnerIdentityCard")String OwnerIdentityCard,@PathVariable("RenterIdentityCard")String RenterIdentityCard,@PathVariable("ficheDePaie")String ficheDePaie,@PathVariable("EngagementLetter")String EngagementLetter,@PathVariable("Rentid")int Sellid)
	{
		SellC.AddSellContract(OwnerIdentityCard,RenterIdentityCard,ficheDePaie,EngagementLetter,Sellid);
    }
	
}
