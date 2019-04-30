package com.example.api.criteria;

import java.util.Map;

public class LessThanCriteria extends KeyValueCriteria implements Criteria {
	
	public LessThanCriteria(String k, String v) {
		super(k, v);
	}

	@Override
	public boolean matches(Map<String, String> user) {
		// age or other field must be < limit
		try {
			return Integer.parseInt(user.get(this.key)) < Integer.parseInt(this.value);
			
		} catch (Exception e) {
			return false;
		}
	}

}
