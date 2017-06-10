package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.LexBotResponse;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.DialogAction;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class DialogActionOnlyLexBotResponse implements LexBotResponse {
    private final DialogAction dialogAction;

    public DialogActionOnlyLexBotResponse(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    @Override
    public DialogAction getDialogAction() {
        return dialogAction;
    }
}
