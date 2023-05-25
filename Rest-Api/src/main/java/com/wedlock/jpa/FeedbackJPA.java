package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.Feedback;

public interface FeedbackJPA extends JpaRepository<Feedback, Long>{

}
