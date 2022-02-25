/**
 * 
 */
package com.example.challenge.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author lfhernandez
 *
 */

@JsonFilter("characterFilter")
public class Character {
	
	long id;
	String name;
	String status;
	String species;
	String type;
	Integer episodeCount;
	Origin origin;
	String[] episode;
	
	public Character() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the episodeCount
	 */
	public Integer getEpisodeCount() {
		return episodeCount;
	}

	/**
	 * @param episodeCount the episodeCount to set
	 */
	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	/**
	 * @return the origin
	 */
	public Origin getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	/**
	 * @return the episode
	 */
	public String[] getEpisode() {
		return episode;
	}

	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(String[] episode) {
		this.episode = episode;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", status=" + status + ", species=" + species + ", type="
				+ type + ", episodeCount=" + episodeCount + ", origin=" + origin + "]";
	}

	
	
}
