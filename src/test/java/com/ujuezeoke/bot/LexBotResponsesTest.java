package com.ujuezeoke.bot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujuezeoke.bot.template.model.response.LexBotResponseBuilder;
import com.ujuezeoke.bot.template.model.response.model.LexBotResponse;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.Buttons;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.FulfillmentState;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.GenericAttachments;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class LexBotResponsesTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void canSerializeLexBotResponse() {
        assertTrue(objectMapper.canSerialize(LexBotResponse.class));
    }

    @Test
    public void canBuildSerializeCloseDialogActionWithoutResponseCard() throws Exception {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildCloseDialogAction()
                .withFulfilmentState(FulfillmentState.Fulfilled)
                .withMessage(DialogActionMessageContentType.PlainText,
                        "Message to convey to the user. For example, Thanks, your pizza has been ordered.")
                .build();


        final JsonNode actualJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(lexBotResponse));
        final JsonNode expectedJsonNode = objectMapper.readTree("{\"dialogAction\": {\n" +
                "    \"type\": \"Close\",\n" +
                "    \"fulfillmentState\": \"Fulfilled\",\n" +
                "    \"message\": {\n" +
                "      \"contentType\": \"PlainText\",\n" +
                "      \"content\": \"Message to convey to the user. For example, Thanks, your pizza has been ordered.\"\n" +
                "    },\"responseCard\":null" +
                "},\"sessionAttributes\":{}}");
        assertThat(actualJsonNode, is(expectedJsonNode));
    }

    @Test
    public void canBuildSerializeCloseDialogActionWithResponseCard() throws Exception {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildCloseDialogAction()
                .withFulfilmentState(FulfillmentState.Fulfilled)
                .withMessage(DialogActionMessageContentType.PlainText,
                        "Message to convey to the user. For example, Thanks, your pizza has been ordered.")
                .withResponseCard(1, new GenericAttachments("card-title", "card-sub-title",
                        new URL("http://localhost/img.jpg"),
                        new URL("http://localhost/img"),
                        new Buttons("button-text", "Value sent to server on button click")
                        ))
                .build();


        final JsonNode actualJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(lexBotResponse));
        final JsonNode expectedJsonNode = objectMapper.readTree("{\"dialogAction\": {\n" +
                "    \"type\": \"Close\",\n" +
                "    \"fulfillmentState\": \"Fulfilled\",\n" +
                "    \"message\": {\n" +
                "      \"contentType\": \"PlainText\",\n" +
                "      \"content\": \"Message to convey to the user. For example, Thanks, your pizza has been ordered.\"\n" +
                "    },\n" +
                "   \"responseCard\": {\n" +
                "      \"version\": 1,\n" +
                "      \"contentType\": \"application/vnd.amazonaws.card.generic\",\n" +
                "      \"genericAttachments\": [\n" +
                "          {\n" +
                "             \"title\":\"card-title\",\n" +
                "             \"subTitle\":\"card-sub-title\",\n" +
                "             \"imageUrl\":\"http://localhost/img.jpg\",\n" +
                "             \"attachmentLinkUrl\":\"http://localhost/img\",\n" +
                "             \"buttons\":[ \n" +
                "                 {\n" +
                "                    \"text\":\"button-text\",\n" +
                "                    \"value\":\"Value sent to server on button click\"\n" +
                "                 }\n" +
                "              ]\n" +
                "           } \n" +
                "       ] \n" +
                "     }\n" +
                "  },\"sessionAttributes\":{}}");
        assertThat(actualJsonNode, is(expectedJsonNode));
    }
}
