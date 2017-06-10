package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.ElicitIntentDialogAction;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.GenericAttachments;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithElicitIntentDialogActionBuilder {

    private DialogActionMessage message;
    private ResponseCard responseCard;
    private Map<String, String> sessionAttributes = new HashMap<>();

    public LexResponseWithElicitIntentDialogActionBuilder withMessage(DialogActionMessageContentType contentType, String content) {
        message = new DialogActionMessage(contentType, content);
        return this;
    }

    public LexResponseWithElicitIntentDialogActionBuilder withResponseCard(Integer version, GenericAttachments... genericAttachments) {
        responseCard = new ResponseCard(version, genericAttachments);
        return this;
    }

    public LexResponseWithElicitIntentDialogActionBuilder withSessionAttribute(String key, String value){
        sessionAttributes.put(key, value);
        return this;
    }

    public LexBotResponse build() {
        return new LexBotResponse(new ElicitIntentDialogAction(message, responseCard), sessionAttributes);
    }
}
