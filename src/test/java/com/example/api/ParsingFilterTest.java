package com.example.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.api.criteria.Criteria;

public class ParsingFilterTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void should_parse_ok_to_create_criterias_from_text() {

		// Input = a JSON like:
		// [{"equals": {"role": "administrator"}}, {"greaterthan": {"age": "30"}}]
		// TODO: parse to
		Map<String, String> innerCriteria = new HashMap<>();
		innerCriteria.put("role", "administrator");
		Map<String, Map<String, String>> criterias = new HashMap<>();
		criterias.put("equals", innerCriteria);

		Iterator<Entry<String, Map<String, String>>> iter = criterias.entrySet().iterator();

		// build list of Criteria objects by a factory
		CriteriaFactory factory = new CriteriaFactory();
		List<Criteria> criteriaList = new ArrayList<>();

		while (iter.hasNext()) {
			Entry<String, Map<String, String>> entry = iter.next();
			Criteria criteria = factory.buildCriteria(entry.getKey(), entry.getValue());
			criteriaList.add(criteria);
		}

		logger.info(criteriaList.toString());

	}

}
