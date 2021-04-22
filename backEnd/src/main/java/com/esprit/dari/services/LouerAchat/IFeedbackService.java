package com.esprit.dari.services.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.LouerAchat.Feedback;

public interface IFeedbackService {
	public String AddFeedback(Feedback f, int adid, Long customerid);

	public List<String> retrieveAllFeedbacks(int idad);

	public void UpdateReview(String review, long feedbackid);

	public float CalculateTotalNote(long idad);

	public String PourcentageOfReactiveCustomers(long idad);

	public String DeleteFeedback(long feedbackid);

	public String getCensoredText(String input);

	public void loadBadWords();
}
