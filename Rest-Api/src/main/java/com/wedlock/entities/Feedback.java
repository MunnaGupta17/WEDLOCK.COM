package com.wedlock.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    private User user; // User who provides the feedback
	
	@Column(name = "rating")
	private int rating; // Rating given by the user
	
	@Column(name = "created_date")
    private LocalDateTime createdDate;
	
	@Column(name = "comment")
	private String comment; // Comment provided by the user

}
