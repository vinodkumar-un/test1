package com.mphasis.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Actor;
import com.mphasis.service.IActorMgmtService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationsController {

	@Autowired
	private IActorMgmtService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor) {
		try {
			String registerActor = service.registerActor(actor);
			return new ResponseEntity<String>(registerActor, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/actors")
	public ResponseEntity<List<Actor>> getAllActors() {
		List<Actor> allActors = new ArrayList<>();
		try {
			allActors = service.getAllActors();
			return new ResponseEntity<List<Actor>>(allActors, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Actor>>(allActors, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/actors1")
	public ResponseEntity<?> getAllActors1() {
		List<Actor> allActors = new ArrayList<>();
		try {
			allActors = service.getAllActors();
			//if(allActors.isEmpty()) 
				return new ResponseEntity<List<Actor>>(allActors, HttpStatus.OK);
			//else
			//	return new ResponseEntity<String>("inter error", HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/actor")
	public ResponseEntity<?> getAllActor(@RequestParam int id) {
		try {
			Actor actor = service.getActorById(id);
			//if(allActors.isEmpty()) 
				return new ResponseEntity<Actor>(actor, HttpStatus.OK);
			//else
			//	return new ResponseEntity<String>("inter error", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/actorCategories")
	public ResponseEntity<?> updateActor(@RequestParam("category1")String category1, @RequestParam("category2")String category2) {
		try {
			List<Actor> actors = service.getActorsByCategories(category1, category2);
			//if(allActors.isEmpty()) 
				return new ResponseEntity<List<Actor>>(actors, HttpStatus.OK);
			//else
			//	return new ResponseEntity<String>("inter error", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actorUpdate")
	public ResponseEntity<String> updateActor(@RequestBody Actor actor) {
		try {
			String msg = service.updateActor(actor);
			//if(allActors.isEmpty()) 
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			//else
			//	return new ResponseEntity<String>("inter error", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
