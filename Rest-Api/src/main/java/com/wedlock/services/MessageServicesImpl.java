package com.wedlock.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedlock.entities.Message;
import com.wedlock.entities.User;
import com.wedlock.exceptionsHandling.MessageException;
import com.wedlock.exceptionsHandling.UserException;
import com.wedlock.jpa.MessageJPA;
import com.wedlock.jpa.UserJPA;

@Service
public class MessageServicesImpl implements MessageServices {

	@Autowired
	private MessageJPA messageRepository;
	@Autowired
	private UserJPA userRepository;

	@Override
	public String sendMessage(Message message) throws MessageException, UserException {
		// TODO Auto-generated method stub
		if (message == null)throw new MessageException("message is null");

		Long receiverId = message.getReceiverId();
		Long senderId = message.getSenderId();
		if (senderId == null || receiverId == null) {
			throw new MessageException("Sender ID or Receiver ID is null");
		}
		Optional<User> senderOptional = userRepository.findById(senderId);
        Optional<User> receiverOptional = userRepository.findById(receiverId);
        if (senderOptional.isEmpty() || receiverOptional.isEmpty()) {
            throw new UserException("Sender or Receiver not found");
        }
        User sender = senderOptional.get();
        User receiver = receiverOptional.get();
        receiver.getReceivedMessages().add(message);
        sender.getSentMessages().add(message);
        
        userRepository.save(sender);
        userRepository.save(receiver);
        
        return "Message sent successfully";
	}

	@Override
	public String editMessage(String messageText,Long messageId) throws MessageException {
		// TODO Auto-generated method stub
		Optional<Message> messageOptional = messageRepository.findById(messageId);
		if(messageOptional.isPresent()) {
			Message message = messageOptional.get();
			message.setMessage(messageText);
			return "Message edited successfully";
		}else {
			throw new MessageException("message not found in db with this id");
		}
	}

	@Override
	public String deleteMessage(Long messageId) throws MessageException {
		// TODO Auto-generated method stub
		Optional<Message> messageOptional = messageRepository.findById(messageId);
		if(messageOptional.isPresent()) {
			Message message = messageOptional.get();
			messageRepository.delete(message);
			return "Message deleted successfully";
		}else {
			throw new MessageException("message not found in db with this id");
		}
	}

}
