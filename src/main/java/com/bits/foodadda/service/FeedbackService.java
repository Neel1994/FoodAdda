package com.bits.foodadda.service;

public interface FeedbackService {
	public int findSentiment(String feedback);
	public String cleanFeedback(String feedback);
	public void storeFeedback(long id, String comment);
}
