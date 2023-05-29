package com.wedlock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wedlock.entities.SearchCriteria;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.SearchCriteriaException;
import com.wedlock.exceptionsHandling.UserException;

@Service
public interface UserServices {

	User getUserById(Long userId)throws UserException;

	User createUser(User user)throws UserException;

	User updateUser(User user,Long userId)throws UserException;

	void deleteUser(Long userId)throws UserException;

	List<User> getAllUsers()throws UserException;

	List<User> searchUsersByCriteria(SearchCriteria criteria)throws SearchCriteriaException;

	List<User> getUsersByLocation(String location);

	List<User> getUsersByGender(String gender);

	List<User> getUsersByAgeRange(int minAge, int maxAge);

	List<User> getUsersByEducation(String education);

	List<User> getUsersByProfession(String profession);
	
	String[] getNullPropertyNames(Object source);

}
