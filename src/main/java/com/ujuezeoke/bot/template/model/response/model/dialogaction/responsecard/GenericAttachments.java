package com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard;

import java.util.Arrays;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class GenericAttachments {
    private final String title;
    private final String subTitle;
    private final String imageUrl;
    private final String attachmentLinkUrl;
    private final Buttons[] buttons;

    public GenericAttachments(String title,
                              String subTitle,
                              String imageUrl,
                              String attachmentLinkUrl,
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
        return imageUrl;
    }

    public String getAttachmentLinkUrl() {
        return attachmentLinkUrl;
    }

    public Buttons[] getButtons() {
        return buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericAttachments that = (GenericAttachments) o;

        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        if (getSubTitle() != null ? !getSubTitle().equals(that.getSubTitle()) : that.getSubTitle() != null)
            return false;
        if (getImageUrl() != null ? !getImageUrl().equals(that.getImageUrl()) : that.getImageUrl() != null)
            return false;
        if (getAttachmentLinkUrl() != null ? !getAttachmentLinkUrl().equals(that.getAttachmentLinkUrl()) : that.getAttachmentLinkUrl() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getButtons(), that.getButtons());
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getSubTitle() != null ? getSubTitle().hashCode() : 0);
        result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
        result = 31 * result + (getAttachmentLinkUrl() != null ? getAttachmentLinkUrl().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getButtons());
        return result;
    }

    @Override
    public String toString() {
        return "GenericAttachments{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", attachmentLinkUrl='" + attachmentLinkUrl + '\'' +
                ", buttons=" + Arrays.toString(buttons) +
                '}';
    }
}
