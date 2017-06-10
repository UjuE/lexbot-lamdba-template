package com.ujuezeoke.bot.template.model.response;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.DialogAction;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexBotResponse implements Serializable {
    private final DialogAction dialogAction;
    private final Map<String, String> sessionAttributes;

    public LexBotResponse(DialogAction dialogAction) {
        this(dialogAction, Collections.emptyMap());
    }

    public LexBotResponse(DialogAction dialogAction, Map<String, String> sessionAttributes) {
        this.dialogAction = dialogAction;
        this.sessionAttributes = sessionAttributes;
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }


    public Map<String, String> getSessionAttributes() {
        return sessionAttributes;
    }
}
