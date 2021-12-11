package com.qa.springfootball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springfootball.domain.Football;
import com.qa.springfootball.repo.FootballRepo;

@Service // Handling all of the business logic!
public class FootballService {
	
	// Dependency 
	private FootballRepo repo; 
	
	public FootballService(FootballRepo repo) {
		this.repo = repo; 
	}
	
	// Create the methods for the interaction between controller & repo
	
	// CREATE
	public Football create(Football fb) {
		return this.repo.saveAndFlush(fb);
	}
	
	// READ
	public List<Football> read(){
		return this.repo.findAll(); 
	}
	
	// UPDATE
	public Football update(Long id, Football newFb) {
		// GET THE RECORD THAT LIVES IN THE DB
		Football existing = this.repo.getById(id); 
		existing.setName(newFb.getName());
		existing.setNoOfPlayers(newFb.getNoOfPlayers());
		existing.setStadiumName(newFb.getStadiumName());
		existing.setYearFounded(newFb.getYearFounded());
		
		Football updated = this.repo.save(existing); // save it back to overwrite the original 
		return updated; 
	}
	
	// DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id); 
	}
	

}
