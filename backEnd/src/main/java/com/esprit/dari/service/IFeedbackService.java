package com.esprit.dari.service;

import java.util.List;

import tn.esprit.spring.entities.Feedback;

public interface IFeedbackService {
	public String AddFeedback(Feedback f, int adid, long customerid);

	public List<String> retrieveAllFeedbacks(int idad);

	public void UpdateReview(String review, long feedbackid);

	public float CalculateTotalNote(long idad);

	public String PourcentageOfReactiveCustomers(long idad);

	public String FlagAReview(long idfeedback);

	public String DeleteFeedback(long feedbackid);

	public String getCensoredText(String input);

	public void loadBadWords();
}
