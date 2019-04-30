package com.example.api;

import java.util.Map;

import com.example.api.criteria.Criteria;

public class Filter {

	private Criteria criteria;
	
	public Filter(Criteria criteria) {
		this.criteria = criteria;
	}

	public boolean matches(Map<String, String> user) {
		//
		return criteria.matches(user);
	}
	
	
}
