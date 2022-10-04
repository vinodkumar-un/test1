package com.mphasis.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Address;
import com.mphasis.model.Politician;

@RestController
@RequestMapping("/politician/api")
public class PoliticianOperationsController {

	@GetMapping("/find/{id}")
	public ResponseEntity<Politician> findPoliticianById(@PathVariable("id") int id) {

		return new ResponseEntity<Politician>(new Politician(id, "modi", "bjp", "PM", 72.0f, new Address("6-11/1", "rgpt", "504251")), HttpStatus.OK);

	}

	@GetMapping("/report")
	public ResponseEntity<List<Politician>> findAllPolitician() {
		List<Politician> list = List.of(new Politician(1, "modi", "bjp", "pm", 72, new Address("6-11/1", "rgpt", "504251")),
				new Politician(2, "amitsha", "bjp", "hm", 70, new Address("6-11/1", "rgpt", "504251")),
				new Politician(3, "kcr", "trs", "cm", 65, new Address("6-11/1", "rgpt", "504251")));
		return new ResponseEntity<List<Politician>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/report1")
	public ResponseEntity<Map<String, String>> showIdCards() {
		Map<String, String> map = Map.of("pancard","BZFPB0606J","aadhar","8677765");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

}
