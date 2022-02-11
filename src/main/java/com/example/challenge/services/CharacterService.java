/**
 * 
 */
package com.example.challenge.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author lfhernandez
 *
 */

@Service
public class CharacterService {
	
	// desde application.properties
	@Value("${character.endpoint}")
	private String endpoint;


	public ResponseEntity<String> getCharacter(String id) throws RestClientException {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity(endpoint+"/{id}", String.class, id);
	}
}
