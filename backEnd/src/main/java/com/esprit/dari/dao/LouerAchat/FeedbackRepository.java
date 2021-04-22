package com.esprit.dari.dao.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.LouerAchat.Feedback;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
	@Query
	("SELECT F.review FROM Feedback F WHERE F.ad = :ad  ")
	List<String> ViewReviews(@Param("ad") Ad ad);
	
	@Query
	("SELECT F.note FROM Feedback F WHERE F.ad = :ad  ")
	List<String>  ViewNotes(@Param("ad") Ad ad); 
	
	@Query
	("SELECT F FROM Feedback F WHERE F.ad = :ad and F.userr = :user ")
	Feedback  FeedbackJPGL(@Param("ad") Ad ad,@Param("user") UserDari user);
	
	@Query("SELECT count(F.userr) FROM Feedback F WHERE F.ad = :ad ")
    public int countReactiveOnes(@Param("ad") Ad ad);
	

}
