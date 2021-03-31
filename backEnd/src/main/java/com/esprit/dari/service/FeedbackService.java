package com.esprit.dari.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;

@Service
public class FeedbackService implements IFeedbackService {
	private static final Logger l = (Logger) LogManager.getLogger(FeedbackService.class);

	static int largestWordLength = 0;
	private static Map<String, String[]> allBadWords = new HashMap<String, String[]>();

	@Autowired
	FeedbackRepository FRep;
	@Autowired
	UserRepository CRep;
	@Autowired
	AdRepository ARep;

	@Override
	public String AddFeedback(Feedback f,int adid, long customerid) {
		long var = 0;
		Calendar calendar = Calendar.getInstance();
		System.out.print("TEST");

		User C = CRep.findById((int) customerid).get();
		System.out.print(ARep.findById(adid).get().getId());
		Ad A = ARep.findById(adid).get();
		
		String rev = f.getReview();
		String rev1 = getCensoredText(rev);

		if (C.getFeedenabled() == 0) {
			if (calendar.getTime().after(C.getFinBlocFeed())) {
				C.setFeedenabled(1);
				C.setDebBlocFeed(null);
				C.setFinBlocFeed(null);
				CRep.save(C);
			}
		}

		if (C.getFeedenabled() == 1) {
			if (FRep.FeedbackJPGL(A, C) == null) {

				f.setReview(rev1);
				f.setAd(A);
				f.setCustomer(C);

				FRep.save(f);
				var = f.getId();
			}
		}

		return rev1;
	}

	@Override
	public List<String> retrieveAllFeedbacks(int idad) {
		Ad ad = ARep.findById(idad).get();
		List<String> reviews = FRep.ViewReviews(ad);
		return reviews;

	}
	
	@Override
	public void UpdateReview(String review, long feedbackid) {
		Feedback F = FRep.findById(feedbackid).get();
		F.setReview(review);
		FRep.save(F);

	}

	@Override
	public String DeleteFeedback(long feedbackid) {
		Feedback F = FRep.findById(feedbackid).get();
		FRep.delete(F);
		return "ok";

	}

	@Override
	public float CalculateTotalNote(long idad) {
		Ad a = ARep.findById((int) idad).get();
		int n = FRep.ViewNotes(a).size();
		List<String> notes = FRep.ViewNotes(a);
		float s = 0;
		for (int i = 0; i < n; i++) {
			float j = Float.parseFloat(notes.get(i));
			s = s + j;

		}
		float NT = (s / n);
		return NT;

	}

	@Override
	public String PourcentageOfReactiveCustomers(long idad) {
		Ad a = ARep.findById((int) idad).get();
		int AllCustomers = CRep.countUsers();
		int ReactCustomers = FRep.countReactiveOnes(a);
		float per = ((100 * ReactCustomers) / AllCustomers);
		String permsg = per + "%";
		return permsg;

	}

	@Override
	public String FlagAReview(long idfeedback) {

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Feedback F = FRep.findById(idfeedback).get();
		User C = F.getUser();

		if (F.isFlagtreated() == false) {

			int flags = F.getFlags() + 1;
			F.setFlags(flags);
			FRep.save(F);
			if (F.getFlags() > 3) {

				C.setFeedenabled(0);
				C.setDebBlocFeed(calendar.getInstance().getTime());
				calendar.add(Calendar.DATE, 03);

				// C.setFinBlocFeed(calendar.add(Calendar.DATE,03).getDate().getInstance().getTime());
				calendar.setTime(C.getDebBlocFeed());
				calendar.add(Calendar.DATE, 7);
				C.setFinBlocFeed(calendar.getTime());
				F.setFlagtreated(true);
				CRep.save(C);
				FRep.save(F);
				return sdf.format(calendar.getTime());

			}

		}

		return sdf.format(calendar.getTime());

	}

	public String getCensoredText(String input) {

		loadBadWords();

		if (input == null) {

			return "";

		}

		String modifiedInput = input;

		// remove leetspeak

		modifiedInput = modifiedInput.replaceAll("1", "i").replaceAll("!", "i").replaceAll("3", "e")
				.replaceAll("4", "a")

				.replaceAll("@", "a").replaceAll("5", "s").replaceAll("7", "t").replaceAll("0", "o")
				.replaceAll("9", "g");

		// ignore any character that is not a letter

		modifiedInput = modifiedInput.toLowerCase().replaceAll("[^a-zA-Z]", "");

		ArrayList<String> badWordsFound = new ArrayList<>();

		// iterate over each letter in the word

		for (int start = 0; start < modifiedInput.length(); start++) {

			// from each letter, keep going to find bad words until either the
			// end of

			// the sentence is reached, or the max word length is reached.

			for (int offset = 1; offset < (modifiedInput.length() + 1 - start)
					&& offset < largestWordLength; offset++) {

				String wordToCheck = modifiedInput.substring(start, start + offset);

				if (allBadWords.containsKey(wordToCheck)) {

					String[] ignoreCheck = allBadWords.get(wordToCheck);

					boolean ignore = false;

					for (int stringIndex = 0; stringIndex < ignoreCheck.length; stringIndex++) {

						if (modifiedInput.contains(ignoreCheck[stringIndex])) {

							ignore = true;

							break;

						}

					}

					if (!ignore) {

						badWordsFound.add(wordToCheck);

					}

				}

			}

		}

		String inputToReturn = input;

		for (String swearWord : badWordsFound) {

			char[] charsStars = new char[swearWord.length()];

			Arrays.fill(charsStars, '*');

			final String stars = new String(charsStars);

			// The "(?i)" is to make the replacement case insensitive.

			inputToReturn = inputToReturn.replaceAll("(?i)" + swearWord, stars);

		}

		return inputToReturn;

	} // end getCensoredText

	
	public void loadBadWords() {

		int readCounter = 0;

		try {

			// The following spreadsheet is from:
			// https://gist.github.com/PimDeWitte/c04cc17bc5fa9d7e3aee6670d4105941

			// (If the spreadsheet ever ceases to exist, then this application
			// will still function normally otherwise - it just won't censor any
			// swear words.)

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new URL("https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv")
							.openConnection().getInputStream()));

			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(new URL(

			// "https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv")

			// .openConnection().getInputStream()));

			String currentLine = "";

			while ((currentLine = reader.readLine()) != null) {

				readCounter++;

				String[] content = null;

				try {

					if (1 == readCounter) {

						continue;

					}

					content = currentLine.split(",");

					if (content.length == 0) {

						continue;

					}

					final String word = content[0];

					if (word.startsWith("-----")) {

						continue;

					}

					if (word.length() > largestWordLength) {

						largestWordLength = word.length();

					}

					String[] ignore_in_combination_with_words = new String[] {};

					if (content.length > 1) {

						ignore_in_combination_with_words = content[1].split("_");

					}

					// Make sure there are no capital letters in the spreadsheet

					allBadWords.put(word.replaceAll(" ", "").toLowerCase(), ignore_in_combination_with_words);

				} catch (Exception except) {

				}

			} // end while

		} catch (IOException except) {

		}

	} // end loadBadWords


}
