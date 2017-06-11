package com.ujuezeoke.bot.template.model.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 09/06/2017.
 */
public class CurrentIntent {
    private final String name;
    private final Map<String, Object> slots;
    private final ConfirmationStatus confirmationStatus;

    //For Jackson
    @SuppressWarnings("unused")
    public CurrentIntent(String name, Map<String, Object> slots, String confirmationStatus) {
        this.name = name;
        this.slots = slots;
        this.confirmationStatus = ConfirmationStatus.valueOf(confirmationStatus);
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

    public static CurrentIntent from(HashMap<String, Object> lexBotRequest) {
        Map<String, Object> currentIntent = (Map<String, Object>) lexBotRequest.get("currentIntent");
        return new CurrentIntent(currentIntent.get("name").toString(),
                (Map<String, Object>) currentIntent.get("slots"),
                currentIntent.get("confirmationStatus").toString());
    }

    @Override
    public String toString() {
        return "CurrentIntent{" +
                "name='" + name + '\'' +
                ", slots=" + slots +
                ", confirmationStatus=" + confirmationStatus +
                '}';
    }
}
