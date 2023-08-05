package com.wedlock.entities;

import java.time.LocalDateTime;

import com.wedlock.enums.ReportStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Report {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String reason;
    
    @Column(nullable = false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User reporterUser;
    
    @ManyToOne
    @JoinColumn(name = "reported_user_id", nullable = false)
    private User reportedUser;
    
    @Column(name = "reported_at")
    private LocalDateTime reportedAt;
    
    private ReportStatus status = ReportStatus.PENDING;

}
