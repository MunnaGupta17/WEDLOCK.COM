package com.wedlock.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wedlock.entities.Photo;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.PhotoException;
import com.wedlock.exceptionsHandling.UserException;
import com.wedlock.jpa.PhotoJPA;
import com.wedlock.jpa.UserJPA;

public class PhotoServicesImpl implements PhotoServices {

	@Autowired
	private UserJPA userRepository;
	@Autowired
	private PhotoJPA photoRepository;

	@Override
	public String addPhoto(Photo photo, Long userid) throws PhotoException, UserException {
		// TODO Auto-generated method stub
		if (photo == null)
			throw new PhotoException("photo is null");
		Optional<User> userOptional = userRepository.findById(userid);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.getPhotos().add(photo);
			userRepository.save(user);
			return "photo added to your profile successfully";
		}else {
			throw new UserException("user not found in db with this id");
		}
	}

	@Override
	public String deletePhoto(Long photoId) throws PhotoException {
		// TODO Auto-generated method stub
		Optional<Photo> photoOptional = photoRepository.findById(photoId);
		if(photoOptional.isPresent()) {
			photoRepository.delete(photoOptional.get());
			return "photo deleted successfully";
		}else {
			throw new PhotoException("photo not found in db with this id");
		}
	}

}
