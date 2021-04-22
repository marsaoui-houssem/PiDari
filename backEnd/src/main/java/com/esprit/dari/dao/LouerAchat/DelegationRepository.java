package com.esprit.dari.dao.LouerAchat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.dari.entities.LouerAchat.*;

@Repository
public interface DelegationRepository extends CrudRepository<Delegation,Integer>{

	
	@Query("select avg(D.Pricepermetre) from Delegation D where D.id=:DelId")
    public int getMetrePricePerDelegation(@Param("DelId") int DelId);
    
	
	@Query("select D.governorate from Delegation D where D.id=:DelId")
	public Governorate getGovernorateByDelegationId(@Param("DelId") int DelId);
	
	/*
	@Query("insert into Delegation(DelegationName,Pricepermetre,governorate) values (:delName,:PricePermetre,:Gov)")
    public void setDelegationMetrePrice(@Param("delName")String delName,@Param("PricePermetre") int PricePermetre,@Param("Gov")Governorate Gov) ;
   
	*/

}