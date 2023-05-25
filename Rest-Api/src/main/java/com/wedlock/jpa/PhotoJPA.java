package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.Photo;

public interface PhotoJPA extends JpaRepository<Photo, Long>{

}
