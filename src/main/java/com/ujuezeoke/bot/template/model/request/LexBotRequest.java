package com.ujuezeoke.bot.template.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by Obianuju Ezeoke on 09/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LexBotRequest {
    private CurrentIntent currentIntent;
    private Bot bot;
    private String userId;
    private String inputTranscript;
    private InvocationSource invocationSource;
    private OutputDialogMode outputDialogMode;
    private String messageVersion;
    private Map<String, Object> sessionAttributes;

    //For Jackson
    @SuppressWarnings("unused")
    public LexBotRequest() {
    }

    @SuppressWarnings("unused")
    public LexBotRequest(CurrentIntent currentIntent, Bot bot,
                         String userId, String inputTranscript,
                         InvocationSource invocationSource,
                         OutputDialogMode outputDialogMode,
                         String messageVersion,
                         Map<String, Object> sessionAttributes) {
        this.currentIntent = currentIntent;
        this.bot = bot;
        this.userId = userId;
        this.inputTranscript = inputTranscript;
        this.invocationSource = invocationSource;
        this.outputDialogMode = outputDialogMode;
        this.messageVersion = messageVersion;
        this.sessionAttributes = sessionAttributes;
    }

    public CurrentIntent getCurrentIntent() {
        return currentIntent;
    }

    public Bot getBot() {
        return bot;
    }

    public String getUserId() {
        return userId;
    }

    public String getInputTranscript() {
        return inputTranscript;
    }

    public InvocationSource getInvocationSource() {
        return invocationSource;
    }

    public OutputDialogMode getOutputDialogMode() {
        return outputDialogMode;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public Map<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public void setCurrentIntent(CurrentIntent currentIntent) {
        this.currentIntent = currentIntent;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setInputTranscript(String inputTranscript) {
        this.inputTranscript = inputTranscript;
    }

    public void setInvocationSource(InvocationSource invocationSource) {
        this.invocationSource = invocationSource;
    }

    public void setOutputDialogMode(OutputDialogMode outputDialogMode) {
        this.outputDialogMode = outputDialogMode;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public void setSessionAttributes(Map<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
}
