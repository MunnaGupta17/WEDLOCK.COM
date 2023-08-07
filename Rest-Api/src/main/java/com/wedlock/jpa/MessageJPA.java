package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wedlock.entities.Message;

@Repository
public interface MessageJPA extends JpaRepository<Message, Long>{

}
