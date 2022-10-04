package com.mphasis.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empNo;
	private String empName;
	private Address address;
	private String[] favColors;
	private List<String> nickNames;
	private Set<Long> phoneNos;
	private Map<String, Long> idDetails;

}
