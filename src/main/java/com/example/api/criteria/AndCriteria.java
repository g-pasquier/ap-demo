package com.example.api.criteria;

import java.util.Map;

public class AndCriteria implements Criteria {

	private Criteria first;
	private Criteria second;
	
	public AndCriteria(Criteria criteria, Criteria other) {
		this.first = criteria;
		this.second = other;
	}

	@Override
	public boolean matches(Map<String, String> user) {
		return first.matches(user) && second.matches(user);
	}

}
