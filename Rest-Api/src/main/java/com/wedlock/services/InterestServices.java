package com.wedlock.services;

import java.util.List;

import com.wedlock.entities.Interest;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.InterestException;
import com.wedlock.exceptionsHandling.UserException;

public interface InterestServices {
	
	Interest createInterest(User user, Long interestedUserId) throws UserException, InterestException;

    void deleteInterest(Long interestId) throws InterestException;

    List<Interest> getInterestsByUser(User user);

    List<Interest> getInterestsByInterestedUser(User interestedUser);

    boolean checkInterestExists(User user, Long interestedUserId);

}
