package com.wedlock.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wedlock.entities.Report;
import com.wedlock.entities.User;

@Repository
public interface ReportJPA extends JpaRepository<Report, Long>{
	
	List<Report> findByReportedUser(User user);
	
	

}
