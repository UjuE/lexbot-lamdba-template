package com.ujuezeoke.bot.template.model.request;

import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 09/06/2017.
 */
public class CurrentIntent {
    private String name;
    private Map<String, Object> slots;
    private ConfirmationStatus confirmationStatus;

    //For Jackson
    @SuppressWarnings("unused")
    public CurrentIntent() {
    }

    public CurrentIntent(String name, Map<String, Object> slots, ConfirmationStatus confirmationStatus) {
        this.name = name;
        this.slots = slots;
        this.confirmationStatus = confirmationStatus;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getSlots() {
        return slots;
    }

    public ConfirmationStatus getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlots(Map<String, Object> slots) {
        this.slots = slots;
    }

    public void setConfirmationStatus(ConfirmationStatus confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }
}
