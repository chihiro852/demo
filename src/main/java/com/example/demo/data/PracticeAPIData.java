package com.example.demo.data;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PracticeAPIData {
	@JsonProperty("name")
	private String name;
	@JsonProperty("note")
	private String note;
	@JsonProperty("age")
	private String age;
	@JsonProperty("registerDate")
	private String registerDate;
	@JsonIgnore
	private Map<String, Object> additionProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("name")
	public String getName(String name) {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

}