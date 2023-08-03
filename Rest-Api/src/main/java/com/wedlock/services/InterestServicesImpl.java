package com.wedlock.services;

import java.util.List;

import com.wedlock.entities.Interest;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.InterestException;
import com.wedlock.exceptionsHandling.UserException;
import com.wedlock.jpa.InterestJPA;
import com.wedlock.jpa.UserJPA;

public class InterestServicesImpl implements InterestServices{
	
	private final InterestJPA interestRepository;
    private final UserJPA userRepository;

    public InterestServicesImpl(InterestJPA interestRepository, UserJPA userRepository) {
        this.interestRepository = interestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Interest createInterest(User user, Long interestedUserId) throws UserException, InterestException {
        // User interestedUser = userRepository.findById(interestedUserId)
        //         .orElseThrow(() -> new UserException("User not found with ID: " + interestedUserId));

        // if (user == null) {
        //     throw new InterestException("Invalid interest data. User must be provided.");
        // }

        // Interest interest = new Interest();
        // interest.setUser(user);
        // interest.setInterestedUser(interestedUser);

        // return interestRepository.save(interest);
    	return null;
    }

    @Override
    public void deleteInterest(Long interestId) throws InterestException {
        Interest interest = interestRepository.findById(interestId)
                .orElseThrow(() -> new InterestException("Interest not found with ID: " + interestId));

        interestRepository.delete(interest);
    }

    @Override
    public List<Interest> getInterestsByUser(User user) {
//        return interestRepository.findByUser(user);
    	return null;
    }

    @Override
    public List<Interest> getInterestsByInterestedUser(User interestedUser) {
//        return interestRepository.findByInterestedUser(interestedUser);
    	return null;
    }

    @Override
    public boolean checkInterestExists(User user, Long interestedUserId) {
//        return interestRepository.existsByUserAndInterestedUser(user, interestedUserId);
    	return true;
    }


}
