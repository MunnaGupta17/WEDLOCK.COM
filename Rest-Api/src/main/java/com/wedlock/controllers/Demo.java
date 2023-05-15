package com.wedlock.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedlock.entities.Interest;
import com.wedlock.entities.User;
import com.wedlock.jpa.InterestJPA;
import com.wedlock.jpa.UserJPA;

@RestController
public class Demo {
    
	@Autowired
	private UserJPA uj;
	
	@Autowired
	private InterestJPA ij;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		uj.save(user);
		return new ResponseEntity<String>("done",HttpStatus.ACCEPTED);
	}
	@PostMapping("/addInterest")
	public ResponseEntity<String> addIntersest(@RequestBody Interest interest){
		ij.save(interest);
		return new ResponseEntity<String>("done",HttpStatus.ACCEPTED);
	}
	@PostMapping("showInterest")
	public ResponseEntity<String> showInterest(@RequestParam Integer InterestId,@RequestParam Integer user2Id){
		Optional<User> user =  uj.findById(user2Id);
		Optional<Interest> inter =  ij.findById(InterestId);
		User Userr = user.get();
		Userr.getInterestedProfiles().add(inter.get());
		return new ResponseEntity<String>("done",HttpStatus.OK);
	}
	
}
