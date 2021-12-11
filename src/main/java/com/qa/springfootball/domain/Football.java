package com.qa.springfootball.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	// Mark this class as a table!
public class Football {
	
	// variables
	@Id // MARK IT AS A PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long id; 
	private String name;
	private int noOfPlayers; 
	private String stadiumName; 
	private int yearFounded;
	
	// constructors
	
	// REQUIRED - default constructor
	public Football() {}
	
	public Football(String name, int noOfPlayers, String stadiumName, int yearFounded) {
		this.name = name; 
		this.noOfPlayers = noOfPlayers; 
		this.stadiumName = stadiumName; 
		this.yearFounded = yearFounded; 
	}
	
	
	public Football(Long id, String name, int noOfPlayers, String stadiumName, int yearFounded) {
		super();
		this.id = id;
		this.name = name;
		this.noOfPlayers = noOfPlayers;
		this.stadiumName = stadiumName;
		this.yearFounded = yearFounded;
	}

	// methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfPlayers() {
		return noOfPlayers;
	}
	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	} 
	
	

}
