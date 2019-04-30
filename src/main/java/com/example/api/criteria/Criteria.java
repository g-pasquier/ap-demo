package com.example.api.criteria;

import java.util.Map;

/**
 * 
 */
public interface Criteria {
	
	boolean matches(Map<String,String> user);
	
	default AndCriteria and(Criteria other) {
		return new AndCriteria(this, other);
	}
	
	default OrCriteria or(Criteria other) {
		return new OrCriteria(this, other);
	}
	
}
