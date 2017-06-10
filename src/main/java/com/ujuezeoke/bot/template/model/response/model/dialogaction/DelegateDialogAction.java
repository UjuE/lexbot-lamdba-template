package com.ujuezeoke.bot.template.model.response.model.dialogaction;

import com.ujuezeoke.bot.template.model.Slot;
import com.ujuezeoke.bot.template.model.response.model.DialogActionType;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class DelegateDialogAction implements DialogAction {
    private final Map<String, Object> slots;

    public DelegateDialogAction(List<Slot> slots) {
        this(slots.stream().collect(toMap(Slot::getKey, Slot::getValue)));
    }

    public DelegateDialogAction(Map<String, Object> slots) {
        this.slots = slots;
    }

    @Override
    public final DialogActionType getType() {
        return DialogActionType.Delegate;
    }

    public Map<String, Object> getSlots() {
        return slots;
    }
}
