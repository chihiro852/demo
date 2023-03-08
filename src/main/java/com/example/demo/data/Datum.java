package com.example.demo.data;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {
	@JsonProperty("name")
	private String name;
	@JsonProperty("note")
	private String note;
	@JsonProperty("age")
	private Integer age;
	@JsonProperty("registerDate")
	private String registerDate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	@JsonProperty("note")
	public void setNote(String note) {
		this.note = note;
	}

	@JsonProperty("age")
	public Integer getAge() {
		return age;
	}

	@JsonProperty("age")
	public void setAge(Integer age) {
		this.age = age;
	}

	@JsonProperty("registerDate")
	public String getRegisterDate() {
		return registerDate;
	}

	@JsonProperty("registerDate")
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
