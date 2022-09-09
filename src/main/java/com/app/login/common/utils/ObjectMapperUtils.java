package com.app.login.common.utils;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.json.JsonParseException;

public class ObjectMapperUtils {

	public static String mapperObjectToJsonString(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	public static String mapToJsonString(Map<String, Object> elements) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(elements);
	}

	@SuppressWarnings("unchecked")
	public static <T> Map<String, Object> classModelToMap(T obj) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(obj, Map.class);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonStringToMap(String jsonStr)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonStr, Map.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonStringToClass(String jsonStr, Class<T> classModel)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonStr, classModel);
	}
}
