package com.esprit.dari.dao.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.LouerAchat.Delegation;
import com.esprit.dari.entities.LouerAchat.Governorate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface GovernorateRepository extends CrudRepository<Governorate,Integer>{

	
	
	@Query("select D from Delegation D where D.governorate.id=:GovId")
	public List<Delegation> getDelegationsByGovernorate(@Param("GovId") int GovId);

	
	@Query("select avg(D.Pricepermetre) from Delegation D where D.governorate.id=:GovId")
    public float getMetrePricePerGovernorate(@Param("GovId") int GovId);

	
}
