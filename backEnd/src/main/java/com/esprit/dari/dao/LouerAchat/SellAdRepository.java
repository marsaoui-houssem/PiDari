package com.esprit.dari.dao.LouerAchat;

import java.util.ArrayList;
import java.util.List;

import com.esprit.dari.entities.LouerAchat.Sell;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SellAdRepository extends CrudRepository<Sell, Integer>{

	@Query("SELECT S FROM Sell S WHERE S.ad_sell.id= :AdId")
	public List<Sell> GetBidByAdId(@Param("AdId")int AdId);

	
}
