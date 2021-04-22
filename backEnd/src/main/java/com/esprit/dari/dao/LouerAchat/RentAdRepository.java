package com.esprit.dari.dao.LouerAchat;

import java.util.ArrayList;
import java.util.List;

import com.esprit.dari.entities.LouerAchat.rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RentAdRepository extends CrudRepository<rent,Integer>{

	
	@Query("SELECT c.ad_rent.id FROM rent c WHERE c.user_rent.userId=:UserId")
	public ArrayList<Integer> getUserRentsJPQL(@Param("UserId") int UserId);
	
	
	
}
