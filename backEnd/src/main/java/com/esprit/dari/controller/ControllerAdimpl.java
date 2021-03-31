package com.esprit.dari.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.AdCriteria;
import tn.esprit.spring.entities.AdEstimation;
import tn.esprit.spring.entities.AdType;
import tn.esprit.spring.entities.Ad_Etat;
import tn.esprit.spring.entities.Delegation;
import tn.esprit.spring.entities.Governorate;
import tn.esprit.spring.service.AdService;
import tn.esprit.spring.service.IAdService;
import tn.esprit.spring.service.IDelegationService;
import tn.esprit.spring.service.IGovernorateService;

@RestController
public class ControllerAdimpl {

	@Autowired
	IAdService adservice;
	
    @Autowired
    IGovernorateService Govservice;
    
    @Autowired
    IDelegationService Delservice;
    
    
	
 //http://localhost:8081/SpringMVC/servlet/AddAd
	@PostMapping("/AddAd")
	@ResponseBody
	public Ad AddAd(@RequestBody Ad ad){
		Ad a=adservice.AddAd(ad);
        
		return a;
	}
	
  //http://localhost:8081/SpringMVC/servlet/findAllAds
	@GetMapping(value = "/findAllAds")
	@ResponseBody
	public List<Ad> findAllAd(){
	return adservice.findAllAds();
	}

 //http://localhost:8081/SpringMVC/servlet/DeleteAdbyId/1
	@DeleteMapping("/deleteAd/{Ad_id}")
	@ResponseBody
	public void DeleteAd(@PathVariable("Ad_id") int AdId){
    adservice.DeleteAdById(AdId);
}
	
	
	//http://localhost:8081/SpringMVC/servlet/affectUsertoAd/1/3
	@PutMapping("/affectUsertoAd/{AdId}/{UserId}")
	@ResponseBody
	public void affectUsertoAd(@PathVariable("AdId") int AdId,@PathVariable("UserId") int UserId)
	{
		adservice.affecterUsertoAd(AdId, UserId);
	}
	
	
    @GetMapping("/GetBestReductions")
	@ResponseBody
	public List<Ad> GetBestReductions()
    {
       return adservice.GetBestReductions();
    }
    
	
  //http://localhost:8081/SpringMVC/servlet/GetAllAdsByState
  	@GetMapping(value = "/GetAllAdsByEtat/{Etat}")
  	@ResponseBody
  	public List<Ad> GetAllAdsByEtat(@PathVariable("Etat") Ad_Etat Etat){
  	return adservice.GetAllAdsByEtat(Etat);
  	}
	 
    
  	
  	@GetMapping(value="/getDelegationsByGovernorate/{GovId}")
  	@ResponseBody
  	public List<Delegation> getDelegationsByGovernorate(@PathVariable("GovId") int GovId)
  	{
  		return Govservice.getDelegationsByGovernorate(GovId);
  	}
  	
  	@GetMapping(value="/getMetrePricePerGovernorate/{GovId}")
  	@ResponseBody
  	public int getMetrePricePerGovernorate(@PathVariable("GovId") int GovId)
  	{
  		return (int) Govservice.getMetrePricePerGovernorate(GovId);
  	}
  	
  	@GetMapping(value="/getMetrePricePerDelegation/{DelId}")
  	@ResponseBody
  	public int getMetrePricePerDelegation(@PathVariable("DelId") int DelId)
  	{
  		return Delservice.getMetrePricePerDelegation(DelId);
  	}
  	
  	@GetMapping(value="/getAllGovernorates")
  	@ResponseBody
  	public List<Governorate> getAllGovernorates()
  	{
  		return Govservice.getAllGovernorates();
  	}
  	
  	//http://localhost:8081/SpringMVC/servlet/setDelegationMetrePrice/1/1400
  	@PostMapping(value="setDelegationMetrePrice/{DelId}/{PricePermetre}")
  	@ResponseBody
  	public void setDelegationMetrePrice(@PathVariable("DelId")int DelId,@PathVariable("PricePermetre")int PricePermetre)
  	{
  		Delservice.setDelegationMetrePrice(DelId,PricePermetre);

  	}
  	
  //http://localhost:8081/SpringMVC/servlet/AddDelegation
  	@PostMapping("/AddDelegation")
  	@ResponseBody
  	public Delegation AddDelegation(@RequestBody Delegation Del){
  		Delegation D=Delservice.AddDelegation(Del);
          
  		return D;
  	}
     
  	
  	//http://localhost:8081/SpringMVC/servlet/findByCriteria/
  	@GetMapping("/findByCriteria")
	 public List<Ad> findByCriteria(@RequestBody AdCriteria AdC) {
  	    return adservice.findByCriteria(AdC);
  	}
  	
  	
  	@GetMapping("/findEstimation")
  	public float findEstimation(@RequestBody AdEstimation AdE) {
  		return adservice.findEstimation(AdE);
  	}
  	
  	
  	@GetMapping("/SearchBytitle/{Text}")
    public List<Ad> SearchBytitle(@PathVariable("Text")String Text){
  		return adservice.SearchBytitle(Text);
  		
  	}
  	
  	}



