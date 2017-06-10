package com.ujuezeoke.bot.template.model.response.model.dialogaction;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class DialogActionMessage {
    private final DialogActionMessageContentType contentType;
    private final String content;

    public DialogActionMessage(DialogActionMessageContentType contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }

    public DialogActionMessageContentType getContentType() {
        return contentType;
    }

    public String getContent() {
        return content;
    }
}
