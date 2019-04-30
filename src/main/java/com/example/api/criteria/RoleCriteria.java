package com.example.api.criteria;

import java.util.Map;

public class RoleCriteria implements Criteria {

	private String role;

	public RoleCriteria(String role) {
		this.role = role;
	}
	
	@Override
	public boolean matches(Map<String, String> user) {
		return user.get("role").equals(this.role);
	}

}
