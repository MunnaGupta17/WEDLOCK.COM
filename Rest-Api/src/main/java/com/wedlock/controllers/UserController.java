package com.wedlock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedlock.entities.Photo;
import com.wedlock.entities.SearchCriteria;
import com.wedlock.entities.User;
import com.wedlock.entities.UserBriefInfo;
import com.wedlock.exceptionsHandling.SearchCriteriaException;
import com.wedlock.exceptionsHandling.UserException;
import com.wedlock.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	 @GetMapping("/{userId}")
	    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
	        try {
	            User user = userService.getUserById(userId);
	            return ResponseEntity.ok(user);
	        } catch (UserException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        try {
	            User createdUser = userService.createUser(user);
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	        } catch (UserException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	    }

	    @PutMapping("/{userId}")
	    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
	        try {
	            User updatedUser = userService.updateUser(user, userId);
	            return ResponseEntity.ok(updatedUser);
	        } catch (UserException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @DeleteMapping("/{userId}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
	        try {
	            userService.deleteUser(userId);
	            return ResponseEntity.noContent().build();
	        } catch (UserException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<User>> getAllUsers() {
	        try {
	            List<User> users = userService.getAllUsers();
	            return ResponseEntity.ok(users);
	        } catch (UserException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    
	    @GetMapping("/location/{location}")
	    public ResponseEntity<List<User>> getUsersByLocation(@PathVariable String location) {
	        List<User> users = userService.getUsersByLocation(location);
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/gender/{gender}")
	    public ResponseEntity<List<User>> getUsersByGender(@PathVariable String gender) {
	        List<User> users = userService.getUsersByGender(gender);
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/age-range")
	    public ResponseEntity<List<User>> getUsersByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
	        List<User> users = userService.getUsersByAgeRange(minAge, maxAge);
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/education/{education}")
	    public ResponseEntity<List<User>> getUsersByEducation(@PathVariable String education) {
	        List<User> users = userService.getUsersByEducation(education);
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/profession/{profession}")
	    public ResponseEntity<List<User>> getUsersByProfession(@PathVariable String profession) {
	        List<User> users = userService.getUsersByProfession(profession);
	        return ResponseEntity.ok(users);
	    }
	    
	    @PostMapping("/search")
	    public ResponseEntity<List<User>> searchUsersByCriteria(@RequestBody SearchCriteria criteria) {
	        try {
	            List<User> users = userService.searchUsersByCriteria(criteria);
	            return ResponseEntity.ok(users);
	        } catch (SearchCriteriaException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	    }
	    
	    @GetMapping("/present")
	    public ResponseEntity<Boolean> isUserPresentInDB(@RequestParam("email") String email, @RequestParam("password") String password){
	    	boolean isPresent = userService.isUserPresent(email, password);
	        return ResponseEntity.ok(isPresent);
	    }
	    
	    @GetMapping("/pics")
	    public ResponseEntity<List<Photo>> getUserPics(@RequestParam("userId") Long userId) throws UserException{
	    
				List<Photo> pics= userService.getUserPics(userId);
			return new ResponseEntity<List<Photo>>(pics,HttpStatus.OK);
	    }
	    
	    public ResponseEntity<UserBriefInfo> getUserBriefInfoController(@RequestParam("userId") Long userId) throws UserException{
	    	UserBriefInfo userBriefInfo = userService.getUserBriefInfo(userId);
	    	return new ResponseEntity<UserBriefInfo>(userBriefInfo,HttpStatus.OK);
	    }

}
