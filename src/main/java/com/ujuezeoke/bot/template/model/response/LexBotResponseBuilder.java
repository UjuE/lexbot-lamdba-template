package com.ujuezeoke.bot.template.model.response;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexBotResponseBuilder {
    public LexResponseWithCloseDialogActionBuilder buildCloseDialogActionResponse() {
        return new LexResponseWithCloseDialogActionBuilder();
    }

    public LexResponseWithConfirmIntentDialogActionBuilder buildConfirmIntentDialogActionResponse() {
        return new LexResponseWithConfirmIntentDialogActionBuilder();
    }

    public LexResponseWithDelegateDialogActionBuilder buildDelegateDialogActionResponse() {
        return new LexResponseWithDelegateDialogActionBuilder();
    }

    public LexResponseWithElicitIntentDialogActionBuilder buildElicitIntentDialogActionResponse() {
        return new LexResponseWithElicitIntentDialogActionBuilder();
    }

    public LexResponseWithElicitSlotDialogActionBuilder buildElicitSlotDialogActionResponse() {
        return new LexResponseWithElicitSlotDialogActionBuilder();
    }
}
