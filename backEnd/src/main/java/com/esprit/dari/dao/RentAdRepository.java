package com.esprit.dari.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.rent;

@Repository
public interface RentAdRepository extends CrudRepository<rent,Integer>{

	
	@Query("SELECT c.ad_rent.id FROM rent c WHERE c.user_rent.id=:UserId")
	public ArrayList<Integer> getUserRentsJPQL(@Param("UserId") int UserId);
	
	
	
}
