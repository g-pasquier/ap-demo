package com.example.api;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * a simple POJO for a Criteria
 * 
 */
public class Criteria {

	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonCreator
	public Criteria (String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Criteria [name=" + name + " id=" + id + "]";
	}
	
}
