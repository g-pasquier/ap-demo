package com.example.api.criteria;

public abstract class KeyValueCriteria implements Criteria {

    protected String key;
    protected String value;

    public KeyValueCriteria(String k, String v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString() {
        return "KeyValueCriteria [key=" + key + ", value=" + value + "]";
    }

}
