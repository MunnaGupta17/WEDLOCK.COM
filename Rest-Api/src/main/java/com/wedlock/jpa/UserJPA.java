package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.User;

public interface UserJPA extends JpaRepository<User, Integer>{

}
