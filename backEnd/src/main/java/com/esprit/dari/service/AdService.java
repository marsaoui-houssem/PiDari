package com.esprit.dari.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

//import com.jayway.jsonpath.Predicate;
import javax.persistence.criteria.Predicate;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.AdCriteria;
import tn.esprit.spring.entities.AdEstimation;
import tn.esprit.spring.entities.AdType;
import tn.esprit.spring.entities.Ad_Etat;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class AdService implements IAdService{
     
	@Autowired
	AdRepository AdR;
	
	@Autowired
	UserRepository UserRep;
	
	@Override
	public Ad AddAd(Ad ad){
         AdR.save(ad);		
	     return ad;
	}
	
	@Override
	public void DeleteAdById(int adId){
	    Ad ad=AdR.findById(adId).get();	
		AdR.delete(ad);
	}
	

	
	@Override
	public void UpdateAdd(int adId){
		Ad ad=AdR.findById(adId).get();
		AdR.save(ad);
	}
	
	@Override
	public List<Ad> findAllAds(){
		return (List<Ad>)AdR.findAll();
	}
	
	@Override
	public Ad findById(int Adid){
		Ad ad=AdR.findById(Adid).get();
		return ad;
	}
	
	@Override
	public void affecterUsertoAd(int AdId, int UserId) {
				
		        User user = UserRep.findById(UserId).get();
				Ad ad = AdR.findById(AdId).get();	
				ad.setUser(user);
				AdR.save(ad);		
    
	}
	
    @Override	
	public List<Ad> GetBestReductions(){

    	int A=(int) AdR.GetAVGReduction();
        System.out.println("A"+A);
    	int C=A+(A/2);
    	List<Ad> L_Best_reduction=AdR.GetBestReduction(C);
        System.out.println(C);
    	return L_Best_reduction;
    }

    

	@Override
	public List<Ad> GetAllAdsByEtat(Ad_Etat Etat){
		return (List<Ad>)AdR.GetAllAdsByEtat(Etat);
	}
	
	
	
	@Override
    public List<Ad> SearchBytitle(String Text){
	  
		return AdR.findByTextContainingIgnoreCase(Text);
		
	}
	

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Ad> findByCriteria(AdCriteria AdC) {
		 CriteriaBuilder builder = em.getCriteriaBuilder();
		 CriteriaQuery<Ad> criteria = builder.createQuery( Ad.class );
		 Root<Ad> AdRoot = criteria.from( Ad.class );
		 criteria.select( AdRoot );
		 List<Predicate> predicates = new ArrayList<>();
		 
	    predicates.add(builder.between(AdRoot.get("price_per_day"),AdC.getMinpriceperday(), AdC.getMaxpriceperday()));
	    predicates.add(builder.between(AdRoot.get("price_per_month"),AdC.getMinpricepermonth(), AdC.getMaxpricepermonth()));
		if(AdC.getDelegation() != null){predicates.add(builder.like(AdRoot.get("Delegation"),AdC.getDelegation()));}
		if(AdC.getGovernorate() != null){predicates.add(builder.like(AdRoot.get("Governorate"),AdC.getGovernorate()));}
	    predicates.add(builder.between(AdRoot.get("surface"),AdC.getMinsurface(),AdC.getMaxsurface()));
	    if(AdC.getNbrpieces()!=0){predicates.add(builder.equal(AdRoot.get("nbrpieces"), AdC.getNbrpieces()));}
	    if(AdC.getRooms()!=0){predicates.add(builder.equal(AdRoot.get("rooms"),AdC.getRooms()));}
	    if(AdC.getEtat()!=null){predicates.add(builder.equal(AdRoot.get("etat"),AdC.getEtat()));}
	    if(AdC.getType()!=null){predicates.add(builder.equal(AdRoot.get("type"),AdC.getType()));}
	    if(AdC.getPiscine()!=null){predicates.add(builder.equal(AdRoot.get("piscine"),AdC.getPiscine()));}
	    criteria.select(AdRoot).where(predicates.toArray(new Predicate[]{}));
		List<Ad>Ads  = em.createQuery( criteria ).getResultList();
        return Ads;	 
}
	
	
	
	@Override
	 public float findEstimation(AdEstimation AdE){
		 CriteriaBuilder builder = em.getCriteriaBuilder();
		 CriteriaQuery<Ad> criteria = builder.createQuery( Ad.class );
		 Root<Ad> AdRoot = criteria.from( Ad.class );
		 criteria.select( AdRoot );
		 List<Predicate> predicates = new ArrayList<>();
		 
		    if(AdE.getDelegation() != null){predicates.add(builder.like(AdRoot.get("Delegation"),AdE.getDelegation()));}
			if(AdE.getGovernorate() != null){predicates.add(builder.like(AdRoot.get("Governorate"),AdE.getGovernorate()));}
		    predicates.add(builder.between(AdRoot.get("surface"),AdE.getMinsurface(),AdE.getMaxsurface()));
		    if(AdE.getNbrpieces()!=0){predicates.add(builder.equal(AdRoot.get("nbrpieces"), AdE.getNbrpieces()));}
		    if(AdE.getRooms()!=0){predicates.add(builder.equal(AdRoot.get("rooms"),AdE.getRooms()));}
		    if(AdE.getEtat()!=null){predicates.add(builder.equal(AdRoot.get("etat"),AdE.getEtat()));}
		    if(AdE.getType()!=null){predicates.add(builder.equal(AdRoot.get("type"),AdE.getType()));}
		    if(AdE.getPiscine()!=null){predicates.add(builder.equal(AdRoot.get("piscine"),AdE.getPiscine()));}
		
		    criteria.select(AdRoot).where(predicates.toArray(new Predicate[]{}));
			List<Ad> Ads = em.createQuery( criteria ).getResultList();
		    
			int Nbr=0;
		    float somme=0;
		    for(Ad Ade : Ads){
		    	Nbr=Nbr+1;
		    	somme=somme+Ade.getPrice_per_day();
		    }
		    int finalSomme=(int) (somme/Nbr);
		  return finalSomme;
	 }
	 
	 
	 
}

