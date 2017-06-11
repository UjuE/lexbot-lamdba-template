package com.ujuezeoke.bot.template.model.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 09/06/2017.
 */
public class LexBotRequest extends HashMap<String, Object> {

    //For Jackson
    @SuppressWarnings("unused")
    public LexBotRequest() {
    }

    public CurrentIntent getCurrentIntent() {
        return CurrentIntent.from(this);
    }

    public Bot getBot() {
        return Bot.from(this);
    }

    public String getUserId() {
        return this.get("userId").toString();
    }

    public String getInputTranscript() {
        return this.get("inputTranscript").toString();
    }

    public InvocationSource getInvocationSource() {
        return InvocationSource.valueOf(this.get("invocationSource").toString());
    }

    public OutputDialogMode getOutputDialogMode() {
        return OutputDialogMode.valueOf(this.get("outputDialogMode").toString());
    }

    public String getMessageVersion() {
        return this.get("messageVersion").toString();
    }

    public Map<String, Object> getSessionAttributes() {
        return (Map<String, Object>) this.get("sessionAttributes");
    }

}
