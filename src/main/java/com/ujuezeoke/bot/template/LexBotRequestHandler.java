package com.ujuezeoke.bot.template;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ujuezeoke.bot.template.model.request.LexBotRequest;
import com.ujuezeoke.bot.template.model.response.LexBotResponse;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
@SuppressWarnings("unused")
public interface LexBotRequestHandler extends RequestHandler<LexBotRequest, LexBotResponse> {
}
