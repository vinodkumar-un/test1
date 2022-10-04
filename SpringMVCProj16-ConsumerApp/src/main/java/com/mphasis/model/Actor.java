package com.mphasis.model;


import lombok.Data;

@Data
public class Actor {
	
	private Integer actorId;
	private String actorName;
	private String category="HERO";
	private long mobileNo=99999999L;

}
