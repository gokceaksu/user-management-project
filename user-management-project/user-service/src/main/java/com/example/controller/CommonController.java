package com.example.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.entity.User;

@RestController
@RequestMapping("/info")
public class CommonController {
	
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{tckn}")
	public void getCommonUserInfo(@PathVariable String tckn) {
		
		JSONObject json = new JSONObject();
		json.put("kisiTipi", "G");
		json.put("uyruk", "TC");
		json.put("tcknVknYkn", tckn);
		
		User user = webClientBuilder.build()
			.get()
			.attribute("cmd", "getKisiByTcknVknYkn")
			.attribute("jp", json.toString())
			.retrieve()
			.bodyToMono(User.class)
			.block();
		System.out.println(user.getName());
	}

}
