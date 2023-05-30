package com.wedlock.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wedlock.entities.Feedback;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.FeedbackNotFoundException;
import com.wedlock.exceptionsHandling.InvalidFeedbackException;

@Service
public interface FeedbackServices {
	
Feedback createFeedback(Feedback feedback) throws InvalidFeedbackException;
    
    Feedback getFeedbackById(Long feedbackId) throws FeedbackNotFoundException;
    
    Feedback updateFeedback(Feedback feedback, Long feedbackId) throws FeedbackNotFoundException,InvalidFeedbackException;
    
    void deleteFeedback(Long feedbackId) throws FeedbackNotFoundException;
    
    List<Feedback> getAllFeedbacks();
    
    List<Feedback> getFeedbacksByUser(User user);
    
    List<Feedback> getFeedbacksByRating(int rating);
    
    List<Feedback> getFeedbacksByDateRange(LocalDate startDate, LocalDate endDate);

}
