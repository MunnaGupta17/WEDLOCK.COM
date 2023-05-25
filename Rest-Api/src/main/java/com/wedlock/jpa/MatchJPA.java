package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.Match;

public interface MatchJPA extends JpaRepository<Match, Long>{

}
