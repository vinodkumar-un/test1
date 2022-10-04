package com.mphasis.service;

import java.util.List;

import com.mphasis.model.Actor;

public interface IActorMgmtService {
	
	public String registerActor(Actor actor);
	public List<Actor> getAllActors();
	public Actor getActorById(int id);
	public String updateActor(Actor actor);
	public List<Actor> getActorsByCategories(String category1, String category2);

}
