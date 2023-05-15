package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.Report;

public interface ReportJPA extends JpaRepository<Report, Integer>{

}
