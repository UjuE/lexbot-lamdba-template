package com.ujuezeoke.bot.template.model.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.FulfillmentState;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.message.DialogActionMessageContentType;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.Buttons;
import com.ujuezeoke.bot.template.model.response.model.dialogaction.responsecard.GenericAttachments;
import org.junit.Test;

import java.io.IOException;

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
                .buildCloseDialogActionResponse()
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
    public void canSerializeCloseDialogActionWithResponseCard() throws Exception {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildCloseDialogActionResponse()
                .withFulfilmentState(FulfillmentState.Fulfilled)
                .withMessage(DialogActionMessageContentType.PlainText,
                        "Message to convey to the user. For example, Thanks, your pizza has been ordered.")
                .withResponseCard(1, new GenericAttachments("card-title", "card-sub-title",
                        "http://localhost/img.jpg",
                        "http://localhost/img",
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

    @Test
    public void canSerializeConfirmIntentDialogActionWithResponseCard() throws Exception {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildConfirmIntentDialogActionResponse()
                .withMessage(DialogActionMessageContentType.SSML,
                        "Message to convey to the user. For example, Are you sure you want a large pizza?")
                .withIntentName("intent-name")
                .withSlot(new Slot("slot-name", "value"))
                .withResponseCard(1, new GenericAttachments("card-title", "card-sub-title",
                        "http://localhost/img.jpg",
                        "http://localhost/img",
                        new Buttons("button-text", "Value sent to server on button click")
                ))
                .build();

        final JsonNode actualJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(lexBotResponse));
        final JsonNode expectedJsonNode = objectMapper.readTree("{\"dialogAction\": {\n" +
                "    \"type\": \"ConfirmIntent\",\n" +
                "    \"message\": {\n" +
                "      \"contentType\": \"SSML\",\n" +
                "      \"content\": \"Message to convey to the user. For example, Are you sure you want a large pizza?\"\n" +
                "    },\n" +
                "   \"intentName\": \"intent-name\",\n" +
                "   \"slots\": {\n" +
                "      \"slot-name\": \"value\"  \n" +
                "   },\n" +
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

    @Test
    public void canSerializeDelegateDialogAction() throws Exception {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildDelegateDialogActionResponse()
                .withSlot(new Slot("slot-name", "value"))
                .withSlot(new Slot("slot-name2", "value"))
                .withSlot(new Slot("slot-name3", "value"))
                .build();

        final JsonNode actualJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(lexBotResponse));
        final JsonNode expectedJsonNode = objectMapper.readTree("{\"dialogAction\":{" +
                "\"slots\":{" +
                "      \"slot-name\": \"value\",\n" +
                "      \"slot-name2\": \"value\",\n" +
                "      \"slot-name3\": \"value\"\n" +
                "}," +
                "\"type\":\"Delegate\"" +
                "},\"sessionAttributes\":{}}");

        assertThat(actualJsonNode, is(expectedJsonNode));
    }

    @Test
    public void canSerializeElicitIntentDialogAction() throws Exception {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildElicitIntentDialogActionResponse()
                .withMessage(DialogActionMessageContentType.SSML,
                        "Message to convey to the user. For example, What can I help you with?")
                .withResponseCard(1, new GenericAttachments("card-title", "card-sub-title",
                        "http://localhost/img.jpg",
                        "http://localhost/img",
                        new Buttons("button-text", "Value sent to server on button click")
                ))
                .build();

        final JsonNode actualJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(lexBotResponse));
        final JsonNode expectedJsonNode = objectMapper.readTree("{" +
                "\"dialogAction\": {\n" +
                "    \"type\": \"ElicitIntent\"," +
                "    \"message\": {\n" +
                "          \"contentType\": \"SSML\",\n" +
                "          \"content\": \"Message to convey to the user. For example, What can I help you with?\"\n" +
                "        },\"responseCard\": {\n" +
                "          \"version\": 1,\n" +
                "          \"contentType\": \"application/vnd.amazonaws.card.generic\",\n" +
                "          \"genericAttachments\": [\n" +
                "              {\n" +
                "                 \"title\":\"card-title\",\n" +
                "                 \"subTitle\":\"card-sub-title\",\n" +
                "                 \"imageUrl\":\"http://localhost/img.jpg\",\n" +
                "                 \"attachmentLinkUrl\":\"http://localhost/img\",\n" +
                "                 \"buttons\":[ \n" +
                "                     {\n" +
                "                        \"text\":\"button-text\",\n" +
                "                        \"value\":\"Value sent to server on button click\"\n" +
                "                     }\n" +
                "                  ]\n" +
                "               } \n" +
                "           ] \n" +
                "         }" +
                "   },\"sessionAttributes\":{}" +
                "}");

        assertThat(actualJsonNode, is(expectedJsonNode));
    }

    @Test
    public void canSerializeELicitSlotWithResponseCard() throws IOException {
        LexBotResponse lexBotResponse = new LexBotResponseBuilder()
                .buildElicitSlotDialogActionResponse()
                .withMessage(DialogActionMessageContentType.PlainText,
                        "Message to convey to the user. For example, What size pizza would you like?")
                .withIntentName("intent-name")
                .withSlot(new Slot("slot-name", "value"))
                .withSlot(new Slot("slot-name2", "value"))
                .withSlot(new Slot("slot-name3", "value"))
                .withSlotToElicit("slot-name")
                .withResponseCard(1, new GenericAttachments("card-title", "card-sub-title",
                        "http://localhost/img.jpg",
                        "http://localhost/img",
                        new Buttons("button-text", "Value sent to server on button click")
                ))
                .build();

        final JsonNode actualJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(lexBotResponse));
        final JsonNode expectedJsonNode = objectMapper.readTree("{\"dialogAction\": {\n" +
                "    \"type\": \"ElicitSlot\",\n" +
                "    \"message\": {\n" +
                "      \"contentType\": \"PlainText\",\n" +
                "      \"content\": \"Message to convey to the user. For example, What size pizza would you like?\"\n" +
                "    },\n" +
                "   \"intentName\": \"intent-name\",\n" +
                "   \"slots\": {\n" +
                "      \"slot-name\": \"value\",\n" +
                "      \"slot-name2\": \"value\",\n" +
                "      \"slot-name3\": \"value\"  \n" +
                "   },\n" +
                "   \"slotToElicit\" : \"slot-name\",\n" +
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
