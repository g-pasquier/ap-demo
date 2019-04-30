package com.example.api.criteria;

import java.util.Map;

public class AgeCriteria implements Criteria {

	private String age;

	public AgeCriteria(String age) {
		this.age = age;
	}
	
	@Override
	public boolean matches(Map<String, String> user) {
		// age must be > limit
		try {
			return Integer.parseInt(user.get("age")) > Integer.parseInt(this.age);
			
		} catch (Exception e) {
			return false;
		}
	}

}
