package com.wedlock.services;

import org.springframework.stereotype.Service;

import com.wedlock.entities.Message;
import com.wedlock.exceptionsHandling.MessageException;
import com.wedlock.exceptionsHandling.UserException;

@Service
public interface MessageServices {
	
    String sendMessage(Message message)throws MessageException,UserException;
    String editMessage(String messageText,Long messageId)throws MessageException;
    String deleteMessage(Long messageId)throws MessageException;
    

}
