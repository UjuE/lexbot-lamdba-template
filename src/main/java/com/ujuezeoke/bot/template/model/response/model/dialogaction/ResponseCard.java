package com.ujuezeoke.bot.template.model.response.model.dialogaction;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class ResponseCard {
    private final Integer version;
    private final GenericAttachments[] genericAttachments;

    public ResponseCard(Integer version, GenericAttachments... genericAttachments) {
        this.version = version;
        this.genericAttachments = genericAttachments;
    }

    public String getContentType() {
        return "application/vnd.amazonaws.card.generic";
    }

    public Integer getVersion() {
        return version;
    }

    public GenericAttachments[] getGenericAttachments() {
        return genericAttachments;
    }
}
