package com.example.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.example.api.criteria.AgeCriteria;
import com.example.api.criteria.RoleCriteria;

public class FilterTest {

	private Map<String, String> user = new LinkedHashMap<>();
	
	@Before
	public void init() {
		// Create user resource having various properties:
		user.put("firstname", "John");
		user.put("lastname", "Doe");
		user.put("role", "administrator");
	}
	
	@Test
	public void should_filter_accept() {
				
		// Create a filter which matches all administrators older than 30:
		AgeCriteria ageCriteria = new AgeCriteria("30");
		RoleCriteria roleCriteria = new RoleCriteria("administrator");
		
		Filter filter = new Filter(ageCriteria.and(roleCriteria));
		
		user.put("age", "35");
		assert filter.matches(user); // Filter should match.
	}
	
	@Test
	public void should_filter_reject() {
		
		AgeCriteria ageCriteria = new AgeCriteria("30");
		RoleCriteria roleCriteria = new RoleCriteria("administrator");
		
		Filter filter = new Filter(ageCriteria.and(roleCriteria));
		
		user.put("age", "25");		
		assert !filter.matches(user); // Filter should not match.
	}
	
}
