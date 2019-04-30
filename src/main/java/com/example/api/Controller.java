package com.example.api;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping(path = "/select")
	public List<String> select(@RequestBody Criteria criteria) {
		
		logger.info(""+  criteria);
		
		return Arrays.asList("Name is " + criteria.getName(), "Id is " + criteria.getId());
	}
	
}
