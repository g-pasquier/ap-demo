package com.example.api.criteria;

import java.util.Map;

public class NotCriteria implements Criteria {

	private Criteria criteria;

	public NotCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public boolean matches(Map<String, String> user) {
		return !criteria.matches(user);
	}

}
