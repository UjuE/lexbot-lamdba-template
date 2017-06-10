package com.ujuezeoke.bot.template.model.response.model.dialogaction;

import com.ujuezeoke.bot.template.model.response.model.DialogActionType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class ElicitSlotDialogAction implements DialogAction {
    private final DialogActionMessage message;
    private final String intentName;
    private final Map<String, Object> slots;
    private final String slotToElicit;
    private final ResponseCard responseCard;

    public ElicitSlotDialogAction(DialogActionMessage message, String intentName,
                                  Map<String, Object> slots, String slotToElicit, ResponseCard responseCard) {
        this.message = message;
        this.intentName = intentName;
        this.slots = slots;
        this.slotToElicit = slotToElicit;
        this.responseCard = responseCard;
    }

    @Override
    public final DialogActionType getType() {
        return DialogActionType.ElicitSlot;
    }

    public DialogActionMessage getMessage() {
        return message;
    }

    public String getIntentName() {
        return intentName;
    }

    public Map<String, Object> getSlots() {
        return slots;
    }

    public String getSlotToElicit() {
        return slotToElicit;
    }

    public ResponseCard getResponseCard() {
        return responseCard;
    }
}
