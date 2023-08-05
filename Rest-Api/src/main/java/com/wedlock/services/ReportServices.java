package com.wedlock.services;

import java.util.List;

import com.wedlock.entities.Report;
import com.wedlock.enums.ReportStatus;
import com.wedlock.exceptionsHandling.ReportException;
import com.wedlock.exceptionsHandling.UserException;

public interface ReportServices {
	
	public Report createReport(Report report) throws ReportException;
	public List<Report> getAllReports();
	public String deleteReport(Long reportId);
	public List<Report> getReportAgainstUser(Long userId)throws UserException;
	public String updateReportStatus(ReportStatus reportStatus,Long reportId)throws IllegalArgumentException,ReportException,UserException;
	public Report updateReport(Report report) throws ReportException; 

}


