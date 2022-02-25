/**
 * 
 */
package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.challenge.entities.Character;
import com.example.challenge.entities.Location;
import com.example.challenge.exceptions.NotFoundException;
import com.example.challenge.services.CharacterServiceImpl;
import com.example.challenge.services.LocationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.apache.commons.validator.routines.*;

/**
 * @author lfhernandez
 *
 */

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	public CharacterServiceImpl characterService;

	@Autowired
	public LocationServiceImpl locationService;

	/**
	 * character/id
	 * @throws NotFoundException 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	@GetMapping("/character/{id}")
    public MappingJacksonValue getCharacter(
    	@PathVariable String id) throws NotFoundException {
				
		//return ResponseEntity.ok(characterService.getCharacter(id));
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
            SimpleBeanPropertyFilter.serializeAllExcept("episode");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("characterFilter", simpleBeanPropertyFilter);

        Character character = characterService.getCharacter(id);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(character);

        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }


}
