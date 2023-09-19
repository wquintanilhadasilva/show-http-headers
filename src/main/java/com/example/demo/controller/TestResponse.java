package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.HashMap;
import java.util.Map;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestResponse {
	@Builder.Default
	private Map<String, String> values = new HashMap<>();
	
	public TestResponse add(String key, String value) {
		values.put(key, value);
		return this;
	}
}
