/**
 * 
 */
package com.example.challenge.services;

import com.example.challenge.entities.Character;
import com.example.challenge.exceptions.NotFoundException;

/**
 * @author lfhernandez
 *
 */
public interface CharacterService {
	public Character getCharacter(String id) throws NotFoundException;
}
