package com.example.demo.Repository;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class PracticeAPIRepository {
	public Map<String, Object> rep() throws JsonMappingException, JsonProcessingException {
		String url = "https://umayadia-apisample.azurewebsites.net/api/persons";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);

		String body = res.getBody();

		ObjectMapper mapper = new ObjectMapper();

		TypeReference<Map<String, Object>> type = new TypeReference<Map<String, Object>>() {
		};

		Map<String, Object> mapBody = mapper.readValue(body, type);

		return mapBody;
	}
}