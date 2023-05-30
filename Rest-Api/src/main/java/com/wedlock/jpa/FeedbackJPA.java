package com.wedlock.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wedlock.entities.Feedback;
import com.wedlock.entities.User;


@Repository
public interface FeedbackJPA extends JpaRepository<Feedback, Long>{
	
	List<Feedback> findByUser(User user);

    List<Feedback> findByRating(int rating);

    @Query("SELECT f FROM Feedback f WHERE f.createdDate BETWEEN :startDate AND :endDate")
    List<Feedback> findByCreatedDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
