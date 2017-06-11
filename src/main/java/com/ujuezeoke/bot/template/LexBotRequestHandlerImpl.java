package com.ujuezeoke.bot.template;

import com.amazonaws.services.lambda.runtime.Context;
import com.ujuezeoke.bot.template.model.request.LexBotRequest;
import com.ujuezeoke.bot.template.model.response.LexBotResponse;
import com.ujuezeoke.bot.template.model.response.model.DialogActionType;

/**
 * Created by Obianuju Ezeoke on 11/06/2017.
 */
public class LexBotRequestHandlerImpl implements LexBotRequestHandler {
    @Override
    public LexBotResponse handleRequest(LexBotRequest input, Context context) {
        System.out.println("Current Intent"+input.getCurrentIntent());
        System.out.println("Bot "+input.getBot());
        return new LexBotResponse(() -> DialogActionType.Close);
    }
}
