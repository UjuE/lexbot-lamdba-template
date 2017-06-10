package com.ujuezeoke.bot.template.model.response.model.dialogaction;

import com.ujuezeoke.bot.template.model.Slot;
import com.ujuezeoke.bot.template.model.response.model.DialogActionType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class ConfirmIntentDialogAction implements DialogAction {
    private final DialogActionMessage dialogActionMessage;
    private final String intentName;
    private final Map<String, Object> slots;
    private final ResponseCard responseCard;

    public ConfirmIntentDialogAction(DialogActionMessage dialogActionMessage, String intentName,
                                     List<Slot> slots, ResponseCard responseCard) {
        this(dialogActionMessage, intentName, slots.stream().collect(toMap(Slot::getKey, Slot::getValue)), responseCard);

    }

    public ConfirmIntentDialogAction(DialogActionMessage dialogActionMessage, String intentName,
                                     Map<String, Object> slots, ResponseCard responseCard) {

        this.dialogActionMessage = dialogActionMessage;
        this.intentName = intentName;
        this.slots = slots;
        this.responseCard = responseCard;
    }

    @Override
    public final DialogActionType getType() {
        return DialogActionType.ConfirmIntent;
    }

    public DialogActionMessage getMessage() {
        return dialogActionMessage;
    }

    public String getIntentName() {
        return intentName;
    }

    public Map<String, Object> getSlots() {
        return slots;
    }

    public ResponseCard getResponseCard() {
        return responseCard;
    }
}
