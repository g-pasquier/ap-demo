package com.example.api;

import java.util.Map;

import com.example.api.criteria.Criteria;
import com.example.api.criteria.EqualsCriteria;
import com.example.api.criteria.ExistsCriteria;
import com.example.api.criteria.GreaterThanCriteria;
import com.example.api.criteria.LessThanCriteria;

public class CriteriaFactory {

	public Criteria buildCriteria(String name, Map<String, String> flatCriterias) {

		String key = (String) flatCriterias.keySet().toArray()[0];
		String value = flatCriterias.get(key);

		switch (name) {

		case "equals":
			return new EqualsCriteria(key, value);

		case "exists":
			return new ExistsCriteria(key);

		case "greaterthan":
			return new GreaterThanCriteria(key, value);

		case "lessthan":
			return new LessThanCriteria(key, value);
		}
		return null;
	}

}
