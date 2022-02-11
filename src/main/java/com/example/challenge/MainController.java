/**
 * 
 */
package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.challenge.entities.Character;
import com.example.challenge.entities.Location;
import com.example.challenge.services.CharacterService;
import com.example.challenge.services.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.validator.routines.*;

/**
 * @author lfhernandez
 *
 */

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	public CharacterService characterService;

	@Autowired
	public LocationService locationService;

	private static boolean isValidURL(String url) {
		UrlValidator defaultValidator = new UrlValidator(); // default schemes
		return defaultValidator.isValid(url);
	}


	/**
	 * character/id
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	@GetMapping("/character/{id}")
    public ResponseEntity<Character> getCharacter(
    	@PathVariable String id) throws JsonMappingException, JsonProcessingException {
				
		ResponseEntity<String> characterResponse = characterService.getCharacter(id);
		System.out.println(characterResponse.getBody());
		
		// tenemos el personaje
		Character character = new Character(characterResponse.getBody());
		
		// vamos por la ubicacion
		if (isValidURL(character.getOrigin().getUrl())) {
			
			ResponseEntity<String> locationResponse = locationService.getLocation(character.getOrigin().getUrl());
			System.out.println(locationResponse.getBody());
			
			// tenemos la ubicacion
			Location location = new Location(locationResponse.getBody());
			
			character.getOrigin().setResidents(location.getResidents());
			character.getOrigin().setDimension(location.getDimension());
		}
		System.out.println("character: " + character.toString());
		return ResponseEntity.ok(character);
    }


}
