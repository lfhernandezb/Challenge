/**
 * 
 */
package com.example.challenge.entities;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author lfhernandez
 *
 */
public class Location {
	long id;
	String name;
	String dimension;
	String[] residents;
	String url;
	String created;
	
	public Location(long id, String name, String dimension, String[] residents, String url, String created) {
		super();
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.residents = residents;
		this.url = url;
		this.created = created;
	}
	
	public Location() {
		
	}
	
	public Location(String jsonString) {
		System.out.println("Location constructor");
		JSONObject obj = new JSONObject(jsonString);
		
		id = obj.getLong("id");
		name = obj.getString("name");
		dimension = obj.getString("dimension");
		//residents = obj.getJSONArray("residents");
		
		JSONArray arr = obj.getJSONArray("residents");
		int size = arr.length();
		
		residents = new String[size];
		
		for (int i = 0; i < arr.length(); i++)
		{
		    residents[i] = arr.getString(i);
		}		
		
		url = obj.getString("url");
		created = obj.getString("created");

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
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the residents
	 */
	public String[] getResidents() {
		return residents;
	}

	/**
	 * @param residents the residents to set
	 */
	public void setResidents(String[] residents) {
		this.residents = residents;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", dimension=" + dimension + ", residents="
				+ Arrays.toString(residents) + ", url=" + url + ", created=" + created + "]";
	}
	
	
}
