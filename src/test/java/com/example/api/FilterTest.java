package com.example.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.example.api.criteria.EqualsCriteria;
import com.example.api.criteria.ExistsCriteria;
import com.example.api.criteria.GreaterThanCriteria;
import com.example.api.criteria.NotCriteria;

/**
 * 
 * @author gpasquier
 *
 */
public class FilterTest {

	private static final String USER_FIRSTNAME = "firstname";
	private static final String USER_LASTNAME = "lastname";
	private static final String USER_AGE = "age";
	private static final String USER_ROLE = "role";
	private static final String ROLE_ADMINISTRATOR = "administrator";

	private Map<String, String> user = new LinkedHashMap<>();

	@Before
	public void init() {
		// Create user resource having various properties:
		user.put(USER_FIRSTNAME, "John");
		user.put(USER_LASTNAME, "Doe");
		user.put(USER_ROLE, ROLE_ADMINISTRATOR);
	}

	@Test
	public void should_filter_accept_admin_by_age() {

		Filter filter = buildAdminAgeFilter();

		user.put(USER_AGE, "35");
		assert filter.matches(user); // Filter should match.
	}

	@Test
	public void should_filter_reject_too_young_admin_dude() {

		Filter filter = buildAdminAgeFilter();

		user.put(USER_AGE, "25");
		assert !filter.matches(user); // Filter should not match.
	}

	private Filter buildAdminAgeFilter() {
		// Create a filter which matches all administrators older than 30:
		EqualsCriteria roleCriteria = new EqualsCriteria(USER_ROLE, ROLE_ADMINISTRATOR);
		GreaterThanCriteria ageCriteria = new GreaterThanCriteria(USER_AGE, "30");

		return new Filter(roleCriteria.and(ageCriteria));
	}

	@Test
	public void should_filter_reject_unnamed() {

		Filter filter = new Filter(new ExistsCriteria(USER_LASTNAME, null));

		user.remove(USER_LASTNAME);
		assert !filter.matches(user); // Filter should not match.
	}

	@Test
	public void should_filter_reject_firstname() {

		Filter filter = new Filter(new EqualsCriteria(USER_FIRSTNAME, "Mike"));

		assert !filter.matches(user); // Filter should not match.
	}

	@Test
	public void should_filter_accept_firstname() {

		Filter filter = new Filter(new EqualsCriteria(USER_FIRSTNAME, "Mike"));

		user.put(USER_FIRSTNAME, "Mike");
		assert filter.matches(user); // Filter should match.
	}

	@Test
	public void should_filter_accept_role_or_another() {

		Filter filter = new Filter(
				new EqualsCriteria(USER_ROLE, "SuperAdmin").or(new EqualsCriteria(USER_ROLE, "BaseAdmin")));

		user.put(USER_ROLE, "BaseAdmin");
		assert filter.matches(user); // Filter should match.
	}

	@Test
	public void should_filter_accept_by_not() {

		// We expect the person to be not named XXX
		Filter filter = new Filter(new NotCriteria(new EqualsCriteria(USER_LASTNAME, "Doe")));

		user.put(USER_LASTNAME, "Donald");
		assert filter.matches(user);
	}

}
