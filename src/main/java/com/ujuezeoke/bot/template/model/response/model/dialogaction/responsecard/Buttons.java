package com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buttons buttons = (Buttons) o;

        if (getText() != null ? !getText().equals(buttons.getText()) : buttons.getText() != null) return false;
        return getValue() != null ? getValue().equals(buttons.getValue()) : buttons.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getText() != null ? getText().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Buttons{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
