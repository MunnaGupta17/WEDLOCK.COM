package com.wedlock.services;

import java.beans.FeatureDescriptor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedlock.entities.Photo;
import com.wedlock.entities.SearchCriteria;
import com.wedlock.entities.User;
import com.wedlock.entities.UserBriefInfo;
import com.wedlock.exceptionsHandling.SearchCriteriaException;
import com.wedlock.exceptionsHandling.UserException;
import com.wedlock.jpa.UserJPA;


@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserJPA userRepository;

	@Override
	public User getUserById(Long userId) throws UserException {
		// TODO Auto-generated method stub
		return userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found with id: " + userId));
	}

	@Override
	public User createUser(User user) throws UserException {
		// TODO Auto-generated method stub
		if(user == null) throw new UserException("User object cannot be null");
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User updatedUser,Long userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            BeanUtils.copyProperties(updatedUser, existingUser, getNullPropertyNames(updatedUser));
            return userRepository.save(existingUser);
        } else {
            throw new UserException("User with ID " + userId + " not found");
        }
	}
	
	// Helper method to get the names of the null properties of an object
	public String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .filter(descriptor -> wrappedSource.getPropertyValue(descriptor.getName()) == null)
                .map(FeatureDescriptor::getName)
                .toArray(String[]::new);
    }

	@Override
	public void deleteUser(Long userId) throws UserException {
		// TODO Auto-generated method stub
		User user = getUserById(userId);
        userRepository.delete(user);
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<User> searchUsersByCriteria(SearchCriteria criteria) throws SearchCriteriaException {
		// TODO Auto-generated method stub	
		if(criteria == null) throw new SearchCriteriaException("criteria object cannot be null");
        return userRepository.searchUsersByCriteria(criteria.getMinAge(),
        		criteria.getMaxAge(),
        		criteria.getLocation(),
        		criteria.getEducation(),
        		criteria.getGender(),
        		criteria.getReligion(),
        		criteria.getCaste(),
        		criteria.getMaritalStatus());
	}

	@Override
	public List<User> getUsersByLocation(String location) {
		// TODO Auto-generated method stub
		return userRepository.findByLocation(location);
	}

	@Override
	public List<User> getUsersByGender(String gender) {
		// TODO Auto-generated method stub
		return userRepository.findByGender(gender);
	}

	@Override
	public List<User> getUsersByAgeRange(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return userRepository.getUsersByAgeRange(minAge, maxAge);
		
	}

	@Override
	public List<User> getUsersByEducation(String education) {
		// TODO Auto-generated method stub
		return userRepository.findByEducation(education);
	}

	@Override
	public List<User> getUsersByProfession(String profession) {
		// TODO Auto-generated method stub
		return userRepository.findByProfession(profession);
	}
	
	@Override
    public boolean isUserPresent(String email, String password) {
        User user = userRepository.findByEmail(email);
        System.out.println("chandan" + user);
        return user != null && user.getPassword().equals(password);
    }

	@Override
	public List<Photo> getUserPics(Long userId) throws UserException {
		// TODO Auto-generated method stub
		User user = getUserById(userId);
		if(user == null) throw new UserException("user not found with this id");
		else return user.getPhotos();
	}

	@Override
	public UserBriefInfo getUserBriefInfo(Long userId) throws UserException {
		// TODO Auto-generated method stub
		User user = getUserById(userId);
		if(user == null) throw new UserException("user not found with this id");
		String name = user.getFirstName()+user.getLastName();
		return new UserBriefInfo(user.getProfilePicture(),name,user.getAge(),user.getDateOfBirth());
	}

}
