package com.mphasis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Politician {
	
	private int pid;
	private String pname;
	private String party;
	private String position;
	private float age;
	private Address address;

}
