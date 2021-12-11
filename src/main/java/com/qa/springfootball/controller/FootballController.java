package com.qa.springfootball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springfootball.domain.Football;
import com.qa.springfootball.service.FootballService;

@RestController // Handles Requests and send MEANINGFUL responses!
@RequestMapping("/football") // http://localhost:9092/football/...
public class FootballController {

	// CRUD Application
	
//	@GetMapping : 	Fetching data FROM a database
//	@PostMapping: 	Send data TO the database
//	@DeleteMapping: Remove data from the database
//	@PutMapping: 	Replace an existing RECORD in a database
//	@PatchMapping: 	Partially update a RECORD in a database
//	@RequestBody : 	Get information from the USER
//	@PathVariable:  Template holder for a value that we get from the USER
	
	// Dependency
	private FootballService service; 
	
	@Autowired
	public FootballController(FootballService service) {
		this.service = service; 
	}
	
	
	
	@GetMapping("/test")
	public String test() {
		return "This is a test"; 
	}
	
	
	// C: Create
	@PostMapping("/create")
	public ResponseEntity<Football> create(@RequestBody Football fb){
		return new ResponseEntity<Football>(this.service.create(fb), HttpStatus.CREATED);
	}
	
	// R: Read
	@GetMapping("/read")
	public ResponseEntity<List<Football>> read(){
		return new ResponseEntity<List<Football>>( this.service.read(), HttpStatus.OK);
	}
	
	// U: Update
	@PutMapping("/replace/{id}")
	public ResponseEntity<Football> update(@PathVariable Long id, @RequestBody Football fb){
		return new ResponseEntity<Football>( this.service.update(id, fb), HttpStatus.ACCEPTED);
	}
	
	// D: Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
	
}
