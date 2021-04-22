package com.esprit.dari.controller.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.LouerAchat.Feedback;
import com.esprit.dari.services.LouerAchat.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerFeedback {

	
	@Autowired
	IFeedbackService ifeed;
	
	// ADD A FEEDBACK : http://localhost:8081/SpringMVC/servlet/addfeedback/1/1
		@PostMapping(value = "/addfeedback/{idUser}/{idAd}")
		@ResponseBody
		public String AddFeedback(@RequestBody Feedback f, @PathVariable("idUser") Long idUser,
								  @PathVariable("idAd") int idAd) {
			System.out.println(idAd);
			System.out.println(idUser);
	    	return	ifeed.AddFeedback(f, idAd, idUser);
			
		}
		
		
	
		
		// UPDATE A REVIEW :
		// http://localhost:8081/SpringMVC/servlet/modif-review/1
		@PutMapping(value = "/modif-review/{review}/{idfeedback}")
		public void MODIFMAIL(@PathVariable("review") String review, @PathVariable("idfeedback") int idfeedback) {
			ifeed.UpdateReview(review, idfeedback);

		}
		 // http://localhost:8081/SpringMVC/servlet/remove-feedback/1 
		 @DeleteMapping("/remove-feedback/{feedbackid}") 
		 @ResponseBody 
		public void removeUser(@PathVariable("feedbackid") int fid) 
		{ 
			 ifeed.DeleteFeedback(fid);
		}


		// VIEW ALL REVIEWS OF AN AD :
		// http://localhost:8081/SpringMVC/servlet/retrieve-feedbacks/1
		@GetMapping(value = "/retrieveFeedbacks/{adid}")
		@ResponseBody
		public List<String> getFeedbacks(@PathVariable("adid") int adid) {
			List<String> reviews = ifeed.retrieveAllFeedbacks(adid);
			return reviews;
		}

		
		// CALCULATE THE TOTAL RATE OF AN AD :
		// http://localhost:8081/SpringMVC/servlet/react-per/1
		@GetMapping(value = "/reactper/{adid}")
		@ResponseBody
		public String getReactPer(@PathVariable("adid") int adid) {
			String per = ifeed.PourcentageOfReactiveCustomers(adid);
			return per;
		}
		
		// CALCULATE THE TOTAL RATE OF AN AD :
		// http://localhost:8081/SpringMVC/servlet/get-note/1
		@GetMapping(value = "/getnote/{adid}")
		@ResponseBody
		public float getNoteTotal(@PathVariable("adid") int adid) {
			float nt = ifeed.CalculateTotalNote(adid);
			return nt;
		}
		
		
		
		
}


