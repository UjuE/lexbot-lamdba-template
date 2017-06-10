package com.ujuezeoke.bot.template.model.response.model.dialogaction;

import com.ujuezeoke.bot.template.model.response.model.DialogActionType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class ElicitIntentDialogAction implements DialogAction {
    private final DialogActionMessage message;
    private final ResponseCard responseCard;

    public ElicitIntentDialogAction(DialogActionMessage message, ResponseCard responseCard) {
        this.message = message;
        this.responseCard = responseCard;
    }

    @Override
    public final DialogActionType getType() {
        return DialogActionType.ElicitIntent;
    }

    public DialogActionMessage getMessage() {
        return message;
    }

    public ResponseCard getResponseCard() {
        return responseCard;
    }
}
