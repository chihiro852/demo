package com.example.demo.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddEntity {
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("data")
	private List<Datum> data;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}

	@JsonProperty("success")
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
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