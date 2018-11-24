package com.bits.foodadda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Feedback;
import com.bits.foodadda.model.Restaurant;
import com.bits.foodadda.repository.FeedbackRepository;
import com.bits.foodadda.repository.RestaurantRepository;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import javax.annotation.PostConstruct;
@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	private StanfordCoreNLP pipeline;
	
	
	
	 @PostConstruct
	    public void init() {
	        pipeline = new StanfordCoreNLP("nlpProp.properties");
	    }
	 
	   public int findSentiment(String feedback) {
	        int mainSentiment = 0;
	        String cleanFeedback = cleanFeedback(feedback);
	        if (cleanFeedback != null && cleanFeedback.length() > 0) {
	            int longest = 0;
	            Annotation annotation = pipeline.process(cleanFeedback);
	            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
	                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
	                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
	                String partText = sentence.toString();
	                if (partText.length() > longest) {
	                    mainSentiment = sentiment;
	                    longest = partText.length();
	                }
	            }
	        }
	        return mainSentiment;
	    }
	   
	   public String cleanFeedback(String feedback) {
	        // make feedback lower case
	        feedback = feedback.toLowerCase();
	        // clean the feedback data
	        feedback = feedback.replaceAll("(@[A-Za-z0-9_]+)|([^0-9A-Za-z \\t])|(\\w+:\\/\\/\\S+)", " ");
	        System.out.println(feedback);
	        return feedback;
	    }
	
	public void storeFeedback(long id, String comment) {
		Restaurant restaurant = restaurantRepository.getRestaurantById(id);
		Feedback feedback = new Feedback(restaurant,comment);
	    int newRating = findSentiment(feedback.getComment());
	    int rating = restaurant.getRating();
	    int ratingCount = restaurant.getRatingCount();
	    double calculatedRating = 0;
	    
	    System.out.println("New Rating being generated : "+newRating);
	    
	    if(ratingCount != 0) {
	   
	    	calculatedRating = ((rating*ratingCount)+newRating)/(++ratingCount);}
	    else
	    	calculatedRating = newRating;
	    
	    //restaurant.setRating((int)Math.round(calculatedRating));
	    restaurant.setRating((int)calculatedRating);
	    restaurant.setRatingCount(ratingCount);
	    restaurantRepository.save(restaurant);
		feedbackRepository.save(feedback);
		
	}
}
