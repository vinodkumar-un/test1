package com.mphasis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mphasis.model.Actor;

public interface IActorRepo extends CrudRepository<Actor, Integer> {
	
	@Query("from Actor where category in(:c1, :c2) order by category")
	public List<Actor> getActorsByCategories(@Param("c1")String category1, @Param("c2")String category2);

}
