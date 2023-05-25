package com.wedlock.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wedlock.entities.User;

public interface UserJPA extends JpaRepository<User, Long>{
	
	List<User> findByProfession(String profession);
	List<User> findByEducation(String education);
	List<User> findByGender(String gender);
	List<User> findByLocation(String location);
	@Query("SELECT u FROM User u WHERE u.age BETWEEN :minAge AND :maxAge")
	List<User> getUsersByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

	


}
