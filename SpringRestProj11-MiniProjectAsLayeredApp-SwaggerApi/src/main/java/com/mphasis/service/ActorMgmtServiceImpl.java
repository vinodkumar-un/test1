package com.mphasis.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.exception.ActorNotFoundException;
import com.mphasis.model.Actor;
import com.mphasis.repo.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	
	@Autowired
	private IActorRepo repo;
	
	@Override
	public String registerActor(Actor actor) {
		Actor actor1 = repo.save(actor);
		return "actor registed with id val: "+actor1.getActorId();
	}
	
	@Override
	public List<Actor> getAllActors() {
		List<Actor> actors = (List<Actor>)repo.findAll();
		//Collections.sort(actors, (obj1, obj2)-> obj1.getActorName().compareTo(obj2.getActorName()));
		StreamSupport.stream(actors.spliterator(), false).sorted((obj1, obj2) -> obj1.getActorName().compareTo(obj2.getActorName())).collect(Collectors.toList());
		return actors;
	}
	
	@Override
	public Actor getActorById(int id) {
		//Actor actor = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Actor not found"));
		Actor actor = repo.findById(id).get();
		
		return actor;
	}
	
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt = repo.findById(actor.getActorId());
		if(opt.isPresent()) {
			repo.save(actor);
			return "Actor Information is updated";
		}else {
			throw new ActorNotFoundException("Actor Information Don't have need not to updated");
		}
	}
	
	@Override
	public List<Actor> getActorsByCategories(String category1, String category2) {
		return repo.getActorsByCategories(category1, category2);
	}

}
