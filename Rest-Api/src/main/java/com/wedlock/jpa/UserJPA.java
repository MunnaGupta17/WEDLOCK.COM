package com.wedlock.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wedlock.entities.User;

@Repository
public interface UserJPA extends JpaRepository<User, Long> {

	List<User> findByProfession(String profession);

	List<User> findByEducation(String education);

	List<User> findByGender(String gender);

	List<User> findByLocation(String location);

	@Query("SELECT u FROM User u WHERE u.age BETWEEN :minAge AND :maxAge")
	List<User> getUsersByAgeRange(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

	@Query("SELECT u FROM User u WHERE (:minAge IS NULL OR u.age >= :minAge) "
			+ "AND (:maxAge IS NULL OR u.age <= :maxAge) " + "AND (:location IS NULL OR u.location = :location) "
			+ "AND (:education IS NULL OR u.education = :education) " + "AND (:gender IS NULL OR u.gender = :gender) "
			+ "AND (:religion IS NULL OR u.religion = :religion) " + "AND (:caste IS NULL OR u.caste = :caste) "
			+ "AND (:maritalStatus IS NULL OR u.maritalStatus = :maritalStatus)")
	List<User> searchUsersByCriteria(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge,
			@Param("location") String location, @Param("education") String education, @Param("gender") String gender,
			@Param("religion") String religion, @Param("caste") String caste,
			@Param("maritalStatus") String maritalStatus);

}
