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
public class LocationService {
	
	public ResponseEntity<String> getLocation(String url) throws RestClientException {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity(url, String.class);
	}
}
