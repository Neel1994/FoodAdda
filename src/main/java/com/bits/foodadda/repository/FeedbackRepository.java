package com.bits.foodadda.repository;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Feedback;


public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
	
}
