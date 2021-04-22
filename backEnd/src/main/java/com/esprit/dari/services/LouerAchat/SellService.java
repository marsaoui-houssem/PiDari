package com.esprit.dari.services.LouerAchat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.LouerAchat.SellAdRepository;
import com.esprit.dari.dao.LouerAchat.UserRepository;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.LouerAchat.Sell;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
@Service
public class SellService implements IAdSellService{

	@Autowired
	AdRepository AdR;
	@Autowired
	UserRepository UserR;
	@Autowired
	SellAdRepository SellR;
	
	
	@Override
	public Sell AddSellAd(Sell S){
         SellR.save(S);	
	     return S;
	}
	
	
	@Override 
	public void DeleteSellAd(int i){
		Sell S=SellR.findById(i).get();
		SellR.delete(S);
	}
	
	
	@Override
	public List<Sell> GetBidByAdId(int AdId)
	{  
		return SellR.GetBidByAdId(AdId);
	}	
	
	@Override
	public void AddBid(int idAd,Long idUser,int Price){
		
		Ad A=AdR.findById(idAd).get();
		UserDari Owner=A.getUser();
		UserDari Buyer=UserR.findById(idUser).get();
		Date D = Calendar.getInstance().getTime();
		Sell S=new Sell();
		S.setAd_title(A.getName());
		S.setBidDate(D);
		S.setBidPrice(Price);
		S.setBuyerFirstName(Buyer.getFirstName());
		S.setBuyerLastName(Buyer.getLastName());
	    S.setOwnerFirstName(Owner.getFirstName());
	    S.setOwnerLastName(Owner.getLastName());
	    S.setAd_sell(A);
	    S.setUser_sell(Buyer);
	    AddSellAd(S);
	    
	}

	
	
}
