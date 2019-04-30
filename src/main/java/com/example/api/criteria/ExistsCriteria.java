package com.example.api.criteria;

import java.util.Map;

public class ExistsCriteria extends KeyValueCriteria implements Criteria {

	public ExistsCriteria(String k, String v) {
		super(k, v);
	}
	
	@Override
	public boolean matches(Map<String, String> user) {
		try {
			return user.containsKey(this.key);
			
		} catch (Exception e) {
			return false;
		}
	}

}
