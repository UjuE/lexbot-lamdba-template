package com.ujuezeoke.bot.template.model.response.model.dialogaction.message;

import com.ujuezeoke.bot.template.model.response.model.dialogaction.DialogAction;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.ResponseCard;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public interface DialogActionWithResponseCard extends DialogAction {
    ResponseCard getResponseCard();
}
