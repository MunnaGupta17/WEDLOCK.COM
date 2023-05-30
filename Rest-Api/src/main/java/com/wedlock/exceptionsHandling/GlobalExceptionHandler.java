package com.wedlock.exceptionsHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userException(UserException ue,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ue.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<ErrorDetails> userException(ReportException re,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), re.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhotoException.class)
	public ResponseEntity<ErrorDetails> userException(PhotoException pe,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), pe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<ErrorDetails> userException(PaymentException pe,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), pe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MessageException.class)
	public ResponseEntity<ErrorDetails> userException(MessageException me,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), me.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MatchException.class)
	public ResponseEntity<ErrorDetails> userException(MatchException me,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), me.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InterestException.class)
	public ResponseEntity<ErrorDetails> userException(InterestException ie,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<ErrorDetails> userException(FeedbackNotFoundException fe,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), fe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidFeedbackException.class)
	public ResponseEntity<ErrorDetails> userException(InvalidFeedbackException fe,WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), fe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}

}
