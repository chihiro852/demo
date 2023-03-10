package com.example.demo.Repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.data.AddEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class PracticeAPIRepository {

	public AddEntity rep() throws JsonMappingException, JsonProcessingException {
		String url = "https://umayadia-apisample.azurewebsites.net/api/persons";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);

		String json = res.getBody();

		ObjectMapper mapper = new ObjectMapper();

		AddEntity addEntity = new AddEntity();

		addEntity = mapper.readValue(json, AddEntity.class);

		return addEntity;
	}
}