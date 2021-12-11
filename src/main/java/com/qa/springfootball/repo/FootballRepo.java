package com.qa.springfootball.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springfootball.domain.Football;

@Repository
public interface FootballRepo extends JpaRepository<Football, Long>{

}
