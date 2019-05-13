package com.example.api.criteria;

import java.util.Map;

public class ExistsCriteria implements Criteria {

    private String key;

    public ExistsCriteria(String key) {
        this.key = key;
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
