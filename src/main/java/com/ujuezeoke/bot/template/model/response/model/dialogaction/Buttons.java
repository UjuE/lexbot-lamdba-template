package com.ujuezeoke.bot.template.model.response.model.dialogaction;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class Buttons {
    private final String text;
    private final String value;

    public Buttons(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
