package com.example.api.criteria;

import java.util.Map;

public class EqualsCriteria extends KeyValueCriteria {

    public EqualsCriteria(String k, String v) {
        super(k, v);
    }

    @Override
    public boolean matches(Map<String, String> user) {
        try {
            return user.containsKey(this.key) && user.get(key).equalsIgnoreCase(value);

        } catch (Exception e) {
            return false;
        }
    }

}
