package com.ujuezeoke.bot.template.model.response.model.dialogaction;

import com.ujuezeoke.bot.template.model.response.model.DialogActionType;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class CloseDialogAction implements DialogAction {
    private final FulfillmentState fulfillmentState;
    private final DialogActionMessage message;
    private final ResponseCard responseCard;

    public CloseDialogAction(FulfillmentState fulfillmentState, DialogActionMessage message, ResponseCard responseCard) {
        this.fulfillmentState = fulfillmentState;
        this.message = message;
        this.responseCard = responseCard;
    }

    final public DialogActionType getType() {
        return DialogActionType.Close;
    }

    public FulfillmentState getFulfillmentState() {
        return fulfillmentState;
    }

    public DialogActionMessage getMessage() {
        return message;
    }

    public ResponseCard getResponseCard() {
        return responseCard;
    }
}
