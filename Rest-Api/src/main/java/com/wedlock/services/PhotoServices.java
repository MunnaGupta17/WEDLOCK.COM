package com.wedlock.services;

import com.wedlock.entities.Photo;
import com.wedlock.exceptionsHandling.PhotoException;
import com.wedlock.exceptionsHandling.UserException;

public interface PhotoServices {
	
	String addPhoto(Photo photo,Long userid) throws PhotoException,UserException;
    String deletePhoto(Long photoId) throws PhotoException;
}
