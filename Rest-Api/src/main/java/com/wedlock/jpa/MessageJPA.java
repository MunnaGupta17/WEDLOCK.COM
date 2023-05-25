package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.Message;

public interface MessageJPA extends JpaRepository<Message, Long>{

}
