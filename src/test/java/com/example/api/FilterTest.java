package com.example.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class FilterTest {

	private Map<String, String> user = new LinkedHashMap<String, String>();
	
	@Before
	public void init() {
		// Create user resource having various properties:
		user.put("firstname", "John");
		user.put("lastname", "Doe");
		user.put("role", "administrator");
	}
	
	@Test
	public void should_filter_accept() {
		
		user.put("age", "35");		

		// Create a filter which matches all administrators older than 30:
		Filter filter = new Filter();
		assert filter.matches(user); // Filter should match.
	}
	
	@Test
	public void should_filter_reject() {
		
		user.put("age", "25");
		
		Filter filter = new Filter();
		
		assert !filter.matches(user); // Filter should not match.
	}
	
}
