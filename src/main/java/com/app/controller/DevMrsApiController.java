package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevMrsApiController {

	@GetMapping("/hello")
	public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		Map<String, Object> result = new HashMap<>();
		result.put("message", String.format("Hello %s!", name));
		result.put("spring_version", SpringVersion.getVersion());
		return result;
	}

}
