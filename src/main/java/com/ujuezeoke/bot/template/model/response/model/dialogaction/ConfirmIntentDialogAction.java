package com.ujuezeoke.bot.template.model.response.model.dialogaction;

import com.ujuezeoke.bot.template.model.response.model.DialogActionType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class ConfirmIntentDialogAction implements DialogAction {
    private final DialogActionMessage dialogActionMessage;
    private final String intentName;
    private final Map<String, Object> slots;
    private final ResponseCard responseCard;

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
