package com.ujuezeoke.bot.template.model.response.model;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.DialogAction;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public interface LexBotResponse {
    default Map<String, Object> getSessionAttributes() {
        return Collections.emptyMap();
    }

    DialogAction getDialogAction();
}
