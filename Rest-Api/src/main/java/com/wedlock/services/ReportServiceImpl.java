package com.wedlock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wedlock.entities.Report;
import com.wedlock.entities.User;
import com.wedlock.enums.ReportStatus;
import com.wedlock.exceptionsHandling.ReportException;
import com.wedlock.exceptionsHandling.UserException;
import com.wedlock.jpa.ReportJPA;
import com.wedlock.jpa.UserJPA;

public class ReportServiceImpl implements ReportServices{
	
	@Autowired
    private ReportJPA reportRepository;
	@Autowired
	private UserJPA userRepository;
	@Autowired
	private UserServices userServices;

    @Override
    public Report createReport(Report report) throws ReportException {
        try {
            return reportRepository.save(report);
        } catch (Exception e) {
            throw new ReportException("Error creating report: " + e.getMessage());
        }
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public String deleteReport(Long reportId) {
        try {
            reportRepository.deleteById(reportId);
            return "Report deleted successfully";
        } catch (Exception e) {
            return "Error deleting report: " + e.getMessage();
        }
    }

    @Override
    public List<Report> getReportAgainstUser(Long userId) throws UserException {
        // Implement this method based on your logic
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
        	return reportRepository.findByReportedUser(user.get());
        }else {
        	throw new UserException("user not present in database with this id");
        }
    }

    @Override
    public String updateReportStatus(ReportStatus reportStatus,Long reportId) throws IllegalArgumentException,ReportException, UserException {
        if (reportStatus == null) {
            throw new IllegalArgumentException("Invalid or missing ReportStatus");
        }
        
        Optional<Report> report = reportRepository.findById(reportId);
        if(report.isPresent()) {
        	Report rep = report.get();
        	rep.setStatus(reportStatus);
        	if(reportStatus == ReportStatus.RESOLVED) {
        		User reporterUser = rep.getReporterUser();
        		userServices.addNotification("Your report is marked as resolved as we have taken action against whom you complaint", reporterUser.getId());
        	}
        }else {
        	throw new ReportException("report is not present with this id in database");
        }
        return null;
    }

    @Override
    public Report updateReport(Report report) throws ReportException {
        if (!reportRepository.existsById(report.getId())) {
            throw new ReportException("Report not found");
        }
        
        try {
            return reportRepository.save(report);
        } catch (Exception e) {
            throw new ReportException("Error updating report: " + e.getMessage());
        }
    }

}
