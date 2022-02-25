/**
 * 
 */
package com.example.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.challenge.entities.Location;

/**
 * @author lfhernandez
 *
 */

@Service
public class LocationServiceImpl {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Location getLocation(String url) throws RestClientException {
		//RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity(url, Location.class).getBody();
	}
}
