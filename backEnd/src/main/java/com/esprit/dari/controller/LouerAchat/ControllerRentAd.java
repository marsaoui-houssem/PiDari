package com.esprit.dari.controller.LouerAchat;

import java.util.Date;
import java.util.List;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.LouerAchat.RentContract;
import com.esprit.dari.entities.LouerAchat.rent;
import com.esprit.dari.services.LouerAchat.RentAdService;
import com.esprit.dari.services.LouerAchat.RentContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerRentAd {

	@Autowired
	RentAdService RAS;
	
	@Autowired
	RentContractService RentCS;
	
	
	@GetMapping(value="/findUserRentsById/{Userid}")
	@ResponseBody
	public List<Ad> findUserRentsById (@PathVariable("Userid") int Userid){
		return RAS.findAdsRentedByUser(Userid);
	}
	
	//http://localhost:8081/SpringMVC/servlet/Addrent/2020-02-14/2020-04-14/1/3
	@PostMapping(value="/Addrent/{datedebut}/{datefin}/{idAd}/{idUser}")
	@ResponseBody
	public void Addrent(@PathVariable("datedebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut,@PathVariable("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin,@PathVariable("idAd")int idAd,@PathVariable("idUser")Long idUser){	
    RAS.Addrent(datedebut,datefin,idAd,idUser);
	}
	

	@PostMapping(value="/AddRentContract/{OwnerIdentityCard}/{RenterIdentityCard}/{ficheDePaie}/{EngagementLetter}/{Rentid}")
	@ResponseBody
	public void AddRentContract(@PathVariable("OwnerIdentityCard")String OwnerIdentityCard,@PathVariable("RenterIdentityCard")String RenterIdentityCard,@PathVariable("ficheDePaie")String ficheDePaie,@PathVariable("EngagementLetter")String EngagementLetter,@PathVariable("Rentid")int Rentid)
	{
		RentCS.AddRentContract(OwnerIdentityCard,RenterIdentityCard,ficheDePaie,EngagementLetter,Rentid);
    }
	
	
	@DeleteMapping(value="/DeleteContractById/{ContractId}")
	@ResponseBody
	public void DeleteContractById(@PathVariable("ContractId")int ContractId)
	{RentCS.DeleteContractById(ContractId);}
	

	
	@GetMapping(value="GetAllContracts")
	@ResponseBody
	public List<RentContract> GetAllContracts(){return RentCS.GetAllContracts();}
	
	
	@GetMapping(value="GetContractById/{ContractId}")
	@ResponseBody
	public RentContract GetContractById(@PathVariable("ContractId")int ContractId){
		return RentCS.GetContractById(ContractId);}
	
	
	@GetMapping(value="findAllRentAds")
	@ResponseBody
	public List<rent> findAllRentAds(){return RAS.findAllRentAds();}
    	
	
	@GetMapping(value="findRentById/{RentId}")
	@ResponseBody
	public rent findRentById(@PathVariable("RentId")int RentId){return RAS.findRentById(RentId);}
    	
	
	@DeleteMapping(value="DeleteRentAdById/{RentId}")
    @ResponseBody
    public void deleteById(@PathVariable("RentId")int RentId){RAS.DeleteRentAdById(RentId);}
	
	
	
	@GetMapping(value="/Calculate_Price/{AdId}/{date_debut}/{date_fin}/{choice}")
	@ResponseBody
	public float Calculate_Price(@PathVariable("AdId")int AdId,@PathVariable("date_debut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_debut,@PathVariable("date_fin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_fin,@PathVariable("choice") String choice)
	{
		return RAS.Calculate_Price(AdId,date_debut,date_fin,choice);
	}
	
}