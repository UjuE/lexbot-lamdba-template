package com.ujuezeoke.bot.template.model;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class Slot {
    private final String key;
    private final Object value;

    public Slot(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
