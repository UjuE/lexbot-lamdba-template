package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.Slot;
import com.ujuezeoke.bot.template.model.response.model.LexBotResponse;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.DelegateDialogAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithDelegateDialogActionBuilder {

    private List<Slot> slots = new ArrayList<>();

    public LexResponseWithDelegateDialogActionBuilder withSlot(Slot slot) {
        slots.add(slot);
        return this;
    }

    public LexBotResponse build() {
        return new DialogActionOnlyLexBotResponse(new DelegateDialogAction(slots));
    }
}
