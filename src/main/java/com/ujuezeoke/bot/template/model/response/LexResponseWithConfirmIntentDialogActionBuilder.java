package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.ConfirmIntentDialogAction;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.GenericAttachments;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithConfirmIntentDialogActionBuilder {

    private DialogActionMessage dialogActionMessage;
    private String intentName;
    private Map<String, Object> slots = new HashMap<>();
    private ResponseCard responseCard;
    private Map<String, String> sessionAttributes = new HashMap<>();

    public LexResponseWithConfirmIntentDialogActionBuilder withMessage(DialogActionMessageContentType contentType,
                                                                       String content) {
        dialogActionMessage = new DialogActionMessage(contentType, content);
        return this;
    }

    public LexResponseWithConfirmIntentDialogActionBuilder withIntentName(String intentName) {
        this.intentName = intentName;
        return this;
    }

    public LexResponseWithConfirmIntentDialogActionBuilder withSlot(Slot slot) {
        slots.put(slot.getKey(), slot.getValue());
        return this;
    }

    public LexResponseWithConfirmIntentDialogActionBuilder withSlots(Map<String, Object> slots) {
        slots.putAll(slots);
        return this;
    }

    public LexResponseWithConfirmIntentDialogActionBuilder withResponseCard(Integer version, GenericAttachments... genericAttachments) {
        responseCard = new ResponseCard(version, genericAttachments);
        return this;
    }

    public LexResponseWithConfirmIntentDialogActionBuilder withSessionAttribute(String key, String value){
        sessionAttributes.put(key, value);
        return this;
    }

    public LexBotResponse build() {
        return new LexBotResponse(new ConfirmIntentDialogAction(
                dialogActionMessage,
                intentName,
                slots,
                responseCard
        ), sessionAttributes);
    }
}
