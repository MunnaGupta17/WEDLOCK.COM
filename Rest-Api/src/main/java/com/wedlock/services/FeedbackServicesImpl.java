package com.wedlock.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wedlock.entities.Feedback;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.FeedbackNotFoundException;
import com.wedlock.exceptionsHandling.InvalidFeedbackException;
import com.wedlock.jpa.FeedbackJPA;

@Service
public class FeedbackServicesImpl implements FeedbackServices{
	
    private FeedbackJPA feedbackRepository;

    public FeedbackServicesImpl(FeedbackJPA feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) throws InvalidFeedbackException {
        if (feedback == null || feedback.getRating() < 1 || feedback.getRating() > 5) {
            throw new InvalidFeedbackException("Invalid feedback data");
        }
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) throws FeedbackNotFoundException {
        return feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback not found with ID: " + feedbackId));
    }

    @Override
    public Feedback updateFeedback(Feedback feedback, Long feedbackId) throws FeedbackNotFoundException, InvalidFeedbackException {
        Feedback existingFeedback = getFeedbackById(feedbackId);
        if (feedback == null || feedback.getRating() < 1 || feedback.getRating() > 5) {
            throw new InvalidFeedbackException("Invalid feedback data");
        }
        existingFeedback.setRating(feedback.getRating());
        existingFeedback.setComment(feedback.getComment());
        return feedbackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedback(Long feedbackId) throws FeedbackNotFoundException {
        Feedback feedback = getFeedbackById(feedbackId);
        feedbackRepository.delete(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public List<Feedback> getFeedbacksByUser(User user) {
        return feedbackRepository.findByUser(user);
    }

    @Override
    public List<Feedback> getFeedbacksByRating(int rating) {
        return feedbackRepository.findByRating(rating);
    }

    @Override
    public List<Feedback> getFeedbacksByDateRange(LocalDate startDate, LocalDate endDate) {
        return feedbackRepository.findByCreatedDateBetween(startDate, endDate);
    }

}
