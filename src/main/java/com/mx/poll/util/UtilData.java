package com.mx.poll.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UtilData {

	public String objectToJsonString(Object data) {

		String jsonStr = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonStr = mapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			log.error("error al convertir ResponseSms a Json.toString() {}", e.getMessage());
		}
		return jsonStr;
	}
}
