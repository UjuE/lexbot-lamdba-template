package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.DelegateDialogAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithDelegateDialogActionBuilder {

    private Map<String, Object> slots = new HashMap<>();
    private Map<String, String> sessionAttributes = new HashMap<>();

    public LexResponseWithDelegateDialogActionBuilder withSlot(Slot slot) {
        slots.put(slot.getKey(), slot.getValue());
        return this;
    }


    public LexResponseWithDelegateDialogActionBuilder withSlots(Map<String, Object> slots) {
        slots.putAll(slots);
        return this;
    }

    public LexResponseWithDelegateDialogActionBuilder withSessionAttribute(String key, String value) {
        sessionAttributes.put(key, value);
        return this;
    }

    public LexBotResponse build() {
        return new LexBotResponse(new DelegateDialogAction(slots), sessionAttributes);
    }
}
