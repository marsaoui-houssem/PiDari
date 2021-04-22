package com.esprit.dari.services.LouerAchat;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.time.*;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.LouerAchat.RentAdRepository;
import com.esprit.dari.dao.LouerAchat.UserRepository;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.LouerAchat.rent;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RentAdService implements IRentAdService{

	@Autowired
	RentAdRepository RentAdR;
	
	@Autowired
	AdRepository AdR;
	
	@Autowired
	UserRepository UserR;
	
	
	@Override
	public rent AddAd(rent R){
         RentAdR.save(R);		
	     return R;
	}
	
	@Override
	public List<rent> findAllRentAds(){
		return (List<rent>)RentAdR.findAll();
	}
	
	@Override
	public rent findRentById(int RentId){
		rent R=RentAdR.findById(RentId).get();
		return R;
	}

	@Override
	public void DeleteRentAdById(int RentId){
	    rent R =RentAdR.findById(RentId).get();	
		RentAdR.delete(R);
	}
	
	/*
	 * 
	@Override
	public void UpdateRent(int RentId){
		rent R=RentAdR.findById(RentId).get();
		RentAdR.save(R);
	}
	
	
	
	*/

	
	// find all the rented properties by user 
	
	@Override 
	public void Addrent(Date datedebut,Date datefin,int idAd,Long idUser)
	{
		rent R=new rent();
		Ad A=AdR.findById(idAd).get();

		UserDari Buyer=UserR.findById(idUser).get();
		
		System.out.println();
		Long SellerId=A.getUser().getUserId();
		//Hedhi badaltha zid thabet feha 
		UserDari Seller=UserR.findById(SellerId).get();
		
		//AdName
		R.setAd_name(A.getName());
		//Buyer Last and first Name
		R.setBuyer_first_name(Buyer.getFirstName());
		R.setBuyer_last_name(Buyer.getLastName());
		
		//Seller Last and first Name
		R.setOwner_first_name(Seller.getFirstName());
		R.setOwner_last_name(Seller.getLastName());
		
		//Date debut et date fin 
		R.setStart_Date(datedebut);
		R.setFinish_Date(datefin);
		
		//Montant
		R.setTotal_Price(4);
		//Buyer foreign key
		R.setUser_rent(Buyer);
		//Ad foreign key
		R.setAd_rent(A);
		
		AddAd(R);
		
		
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	//Calculate the price of the Ad to rent 
		@Override
		public float Calculate_Price(int AdId,Date date_debut,Date date_fin,String choice){
			
			float Taux_reduction=AdR.findById(AdId).get().getTaux_reduction();
	        float price_per_day=(float)AdR.findById(AdId).get().getPrice_per_day();
	        float price_per_month=(float)AdR.findById(AdId).get().getPrice_per_month();
			float price=0;
			long Nb =getDateDiff(date_debut,date_fin,TimeUnit.DAYS);
            System.out.println("Diff des jours "+Nb);
            System.out.println("choice"+choice);
            System.out.println("price_per_day"+price_per_day);
			if(choice.equals("Jour")) { 
				if(Nb<15){price=price_per_day*Nb;}
				else price = price_per_day*Nb*(Taux_reduction/100);
			                   }
			else if (choice.equals("mois")) {
				if((Nb/30)<6){price=price_per_month*(Nb/30);}
				else price = price_per_month*(Nb/30)*(Taux_reduction/100);
			}
	    return price;
		}
	
		@Override
		public List<Ad> findAdsRentedByUser(int UserId)
		{
			
			ArrayList<Integer> AdsIds = RentAdR.getUserRentsJPQL(UserId);
	        ArrayList<Ad> Ads=new ArrayList<Ad>();
	        Ad a = new Ad();
	        Ads = (ArrayList<Ad>) AdR.findAllById(AdsIds);
	        return Ads;
		}

}
