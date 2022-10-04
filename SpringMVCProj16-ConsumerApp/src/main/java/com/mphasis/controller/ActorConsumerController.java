package com.mphasis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mphasis.model.Actor;

@Controller
public class ActorConsumerController {

	@Autowired
	private RestTemplate template;

	@Autowired
	private Environment env;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/actor_report")
	public String fetchAllActors(Map<String, Object> map) throws Exception {
		// http://localhost:7070/SpringRestProj16-MiniProject-ProviderApp/actor/api/actors
		String serviceUrl = env.getProperty("fetchAllActors.serviceUrl");
		// String serviceUrl =
		// "http://localhost:7070/SpringRestProj16-MiniProject-ProviderApp/actor/api/actors";
		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		String jsonBody = responseEntity.getBody();
		System.out.println("Json Response: " + jsonBody);
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> listActor = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {
		});
		System.out.println("Java Response: " + listActor);
		map.put("actorsInfo", listActor);
		return "show_report";
	}

	@GetMapping("/actor_add")
	public String showRegisterActorFormPage(@ModelAttribute("actor") Actor actor) {

		return "register_actor";
	}
	
//	@PostMapping("/actor_add")
//	public String registerActor(@ModelAttribute("actor") Actor actor, Map<String, Object> map) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonContent = mapper.writeValueAsString(actor);
//		System.out.println("register actor:: "+jsonContent);
//		String serviceUrl = env.getProperty("registerActor.serviceUrl");
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> entity = new HttpEntity<>(jsonContent, headers);
//		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
//		String msg = responseEntity.getBody();
//		map.put("resultMsg", msg);
//		
//		return "redirect:actor_report";
//	}
	
	@PostMapping("/actor_add")
	public String registerActor(@ModelAttribute("actor") Actor actor, RedirectAttributes attrs) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = mapper.writeValueAsString(actor);
		System.out.println("register actor:: "+jsonContent);
		String serviceUrl = env.getProperty("registerActor.serviceUrl");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(jsonContent, headers);
		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		String msg = responseEntity.getBody();
		System.out.println("====================================="+msg+"-----------------------------");
		attrs.addFlashAttribute("resultMsg", msg);
		
		return "redirect:actor_report";
	}

}
