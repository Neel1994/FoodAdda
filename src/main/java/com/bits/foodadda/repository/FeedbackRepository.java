package com.bits.foodadda.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Feedback;


public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
	

	@Query("select f from Feedback f")
	public List<Feedback> getFeedbackList();
}
