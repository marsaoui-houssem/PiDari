package com.esprit.dari.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Feedback;
import tn.esprit.spring.entities.Ad;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
	@Query
	("SELECT F.review FROM Feedback F WHERE F.ad = :ad  ")
	List<String> ViewReviews(@Param("ad") Ad ad);
	
	@Query
	("SELECT F.note FROM Feedback F WHERE F.ad = :ad  ")
	List<String>  ViewNotes(@Param("ad") Ad ad); 
	
	@Query
	("SELECT F FROM Feedback F WHERE F.ad = :ad and F.user = :user ")
	Feedback  FeedbackJPGL(@Param("ad") Ad ad,@Param("user") User user); 
	
	@Query("SELECT count(user) FROM Feedback F WHERE F.ad = :ad ")
    public int countReactiveOnes(@Param("ad") Ad ad);
	

}
