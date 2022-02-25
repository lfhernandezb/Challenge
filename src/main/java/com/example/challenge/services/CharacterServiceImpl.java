/**
 * 
 */
package com.example.challenge.services;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.challenge.RestTemplateResponseErrorHandler;
import com.example.challenge.entities.Character;
import com.example.challenge.entities.Location;
import com.example.challenge.exceptions.NotFoundException;

/**
 * @author lfhernandez
 *
 */

@Service
public class CharacterServiceImpl implements CharacterService {
	
	@Autowired
	private LocationServiceImpl locationService;

	@Autowired
	private RestTemplate restTemplate;
	
	// desde application.properties
	@Value("${character.endpoint}")
	private String endpoint;

	private static boolean isValidURL(String url) {
		UrlValidator defaultValidator = new UrlValidator(); // default schemes
		return defaultValidator.isValid(url);
	}

	public Character getCharacter(String id) throws NotFoundException {
		//RestTemplate restTemplate = new RestTemplate();
		try {
			System.out.println(restTemplate);
			Character character = restTemplate.getForEntity(endpoint+"/{id}", Character.class, id).getBody();
			
			character.setEpisodeCount(character.getEpisode().length);
			
			System.out.println(character);
			
			// vamos por la ubicacion
			if (isValidURL(character.getOrigin().getUrl())) {
				
				Location location = locationService.getLocation(character.getOrigin().getUrl());
				System.out.println(location);
				
				// tenemos la ubicacion
				
				character.getOrigin().setResidents(location.getResidents());
				character.getOrigin().setDimension(location.getDimension());
			}
			
			return character;
		} catch (HttpClientErrorException e) {
			
		    HttpStatus status = e.getStatusCode();
		    if (status != HttpStatus.NOT_FOUND) { throw e; }
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new NotFoundException("Please entes a digit!!!!!");
		}
	}
}