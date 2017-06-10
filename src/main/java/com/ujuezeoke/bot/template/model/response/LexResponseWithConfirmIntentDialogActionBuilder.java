package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.Slot;
import com.ujuezeoke.bot.template.model.response.model.LexBotResponse;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.ConfirmIntentDialogAction;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessage;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.GenericAttachments;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexResponseWithConfirmIntentDialogActionBuilder {

    private DialogActionMessage dialogActionMessage;
    private String intentName;
    private List<Slot> slots = new ArrayList<>();
    private ResponseCard responseCard;

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
        slots.add(slot);
        return this;
    }

    public LexResponseWithConfirmIntentDialogActionBuilder withResponseCard(Integer version, GenericAttachments... genericAttachments) {
        responseCard = new ResponseCard(version, genericAttachments);
        return this;
    }

    public LexBotResponse build() {
        return new DialogActionOnlyLexBotResponse(new ConfirmIntentDialogAction(
                dialogActionMessage,
                intentName,
                slots,
                responseCard
        ));
    }
}