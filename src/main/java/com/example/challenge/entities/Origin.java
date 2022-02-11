/**
 * 
 */
package com.example.challenge.entities;

import java.util.Arrays;

/**
 * @author lfhernandez
 *
 */
public class Origin {
	String name;
	String url;
	String dimension;
	String[] residents;
	
	public Origin(String name, String url, String dimension, String[] residents) {
		super();
		this.name = name;
		this.url = url;
		this.dimension = dimension;
		this.residents = residents;
	}
	
	public Origin() {
		
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

	@Override
	public String toString() {
		return "Origin [name=" + name + ", url=" + url + ", dimension=" + dimension + ", residents="
				+ Arrays.toString(residents) + "]";
	}
	
	
}
