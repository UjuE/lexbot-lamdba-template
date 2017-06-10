package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.LexBotResponse;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.*;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.GenericAttachments;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithCloseDialogActionBuilder {
    private FulfillmentState fulfillmentState;
    private DialogActionMessage dialogActionMessage;
    private ResponseCard responseCard;

    public LexResponseWithCloseDialogActionBuilder withFulfilmentState(FulfillmentState fulfillmentState) {
        this.fulfillmentState = fulfillmentState;

        return this;
    }

    public LexResponseWithCloseDialogActionBuilder withMessage(DialogActionMessageContentType contentType, String content) {
        dialogActionMessage = new DialogActionMessage(contentType, content);
        return this;
    }

    public LexResponseWithCloseDialogActionBuilder withResponseCard(Integer version, GenericAttachments... genericAttachments) {
        responseCard = new ResponseCard(version, genericAttachments);
        return this;
    }

    public LexBotResponse build() {
        return new DialogActionOnlyLexBotResponse(new CloseDialogAction(fulfillmentState, dialogActionMessage, responseCard));
    }
}
