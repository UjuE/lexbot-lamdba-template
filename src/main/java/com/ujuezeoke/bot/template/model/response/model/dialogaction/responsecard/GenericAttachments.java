package com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard;



import java.net.URL;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class GenericAttachments {
    private final String title;
    private final String subTitle;
    private final URL imageUrl;
    private final URL attachmentLinkUrl;
    private final Buttons[] buttons;

    public GenericAttachments(String title,
                              String subTitle,
                              URL imageUrl,
                              URL attachmentLinkUrl,
                              Buttons... buttons) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageUrl = imageUrl;
        this.attachmentLinkUrl = attachmentLinkUrl;
        this.buttons = buttons;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getImageUrl() {
        return imageUrl.toExternalForm();
    }

    public String getAttachmentLinkUrl() {
        return attachmentLinkUrl.toExternalForm();
    }

    public Buttons[] getButtons() {
        return buttons;
    }
}
