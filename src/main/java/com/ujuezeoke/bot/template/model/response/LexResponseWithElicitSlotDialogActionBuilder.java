package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.ElicitSlotDialogAction;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.GenericAttachments;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithElicitSlotDialogActionBuilder {

    private DialogActionMessage message;
    private ResponseCard responseCard;
    private String intentName;
    private Map<String, Object> slots = new HashMap<>();
    private String slotToElicit;

    public LexResponseWithElicitSlotDialogActionBuilder withMessage(DialogActionMessageContentType contentType, String content) {
        message = new DialogActionMessage(contentType, content);
        return this;
    }

    public LexResponseWithElicitSlotDialogActionBuilder withResponseCard(Integer version, GenericAttachments... genericAttachments) {
        responseCard = new ResponseCard(version, genericAttachments);
        return this;
    }

    public LexResponseWithElicitSlotDialogActionBuilder withIntentName(String intentName) {
        this.intentName = intentName;
        return this;
    }

    public LexResponseWithElicitSlotDialogActionBuilder withSlot(Slot slot) {
        slots.put(slot.getKey(), slot.getValue());
        return this;
    }

    public LexResponseWithElicitSlotDialogActionBuilder withSlotToElicit(String slotToElicit) {
        this.slotToElicit = slotToElicit;
        return this;
    }

    public LexBotResponse build() {
        return new LexBotResponse(new ElicitSlotDialogAction(
                message,
                intentName,
                slots,
                slotToElicit,
                responseCard
        ));
    }
}
