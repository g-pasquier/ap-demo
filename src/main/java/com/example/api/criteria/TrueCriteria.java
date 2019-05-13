package com.example.api.criteria;

import java.util.Map;

/**
 * 
 * is always True
 *
 */
public class TrueCriteria implements Criteria {

    @Override
    public boolean matches(Map<String, String> user) {
        return true;
    }

}
