package com.ujuezeoke.bot.template.model;

import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

/**
 * Created by Obianuju Ezeoke on 09/06/2017.
 */
public class RequestTemplateHelper {
    /*
    {
  "currentIntent": {
    "name": "intent-name",
    "slots": {
      "slot-name": "value",
      "slot-name": "value",
      "slot-name": "value"
    },
    "confirmationStatus": "None, Confirmed, or Denied (intent confirmation, if configured)",
  },
  "bot": {
    "name": "bot-name",
    "alias": "bot-alias",
    "version": "bot-version"
  },
  "userId": "User ID specified in the POST request to Amazon Lex.",
  "inputTranscript": "Text used to process the request",
  "invocationSource": "FulfillmentCodeHook or DialogCodeHook",
  "outputDialogMode": "Text or Voice, based on ContentType request header in runtime API request",
  "messageVersion": "1.0",
  "sessionAttributes": {
     "key1": "value1",
     "key2": "value2"
  }
}
     */
    private static final String REQUEST_TEMPLATE_HELPER = "{\n" +
            "  \"currentIntent\": {\n" +
            "    \"name\": \"%s\",\n" +
            "    \"slots\": {\n" +
            "%s" +

            "    },\n" +
            "    \"confirmationStatus\": \"%s\"\n" +
            "  },\n" +
            "  \"bot\": {\n" +
            "%s" +
            "  },\n" +
            "  \"userId\": \"%s\",\n" +
            "  \"inputTranscript\": \"%s\",\n" +
            "  \"invocationSource\": \"%s\",\n" +
            "  \"outputDialogMode\": \"%s\",\n" +
            "  \"messageVersion\": \"%s\",\n" +
            "  \"sessionAttributes\": { \n" +
            "     %s" +
            "  }%s\n" +
            "}";

    private static String withBotDetails(final String botName, final String botAlias, final String botVersion) {
        return "    \"name\": \"" + botName + "\",\n" +
                "    \"alias\": \"" + botAlias + "\",\n" +
                "    \"version\": \"" + botVersion + "\"\n";
    }

    private static String withBotDetails(final String botName, final String botVersion) {
        return "    \"name\": \"" + botName + "\",\n" +
                "    \"alias\": null,\n" +
                "    \"version\": \"" + botVersion + "\"\n";
    }

    private static String withKeyValuePairs(Map<String, String> slots) {
        return slots.entrySet()
                .stream()
                .map(it -> format("\"%s\":\"%s\"", it.getKey(), it.getValue()))
                .collect(joining(","));
    }

    public static String lexRequestWith(String currentIntent,
                                        Map<String, String> slots,
                                        String confirmationStatus, String botName,
                                        String botAlias, String botVersion,
                                        String userId, String inputTranscript,
                                        String invocationSource,
                                        String outputDialogMode,
                                        String messageVersion,
                                        Map<String, String> sessionAttributes) {
        return format(REQUEST_TEMPLATE_HELPER, currentIntent, withKeyValuePairs(slots),
                confirmationStatus, withBotDetails(botName, botAlias, botVersion), userId,
                inputTranscript, invocationSource, outputDialogMode, messageVersion,
                withKeyValuePairs(sessionAttributes),"");
    }

    public static String lexRequestWith(String currentIntent,
                                        Map<String, String> slots,
                                        String confirmationStatus, String botName,
                                        String botVersion,
                                        String userId, String inputTranscript,
                                        String invocationSource,
                                        String outputDialogMode,
                                        String messageVersion,
                                        Map<String, String> sessionAttributes) {
        return format(REQUEST_TEMPLATE_HELPER, currentIntent, withKeyValuePairs(slots),
                confirmationStatus, withBotDetails(botName, botVersion), userId,
                inputTranscript, invocationSource, outputDialogMode, messageVersion,
                withKeyValuePairs(sessionAttributes),"");
    }

    public static String lexRequestWith(String currentIntent,
                                        Map<String, String> slots,
                                        String confirmationStatus, String botName,
                                        String botAlias, String botVersion,
                                        String userId, String inputTranscript,
                                        String invocationSource,
                                        String outputDialogMode,
                                        String messageVersion,
                                        Map<String, String> sessionAttributes, String additional) {
        return format(REQUEST_TEMPLATE_HELPER, currentIntent, withKeyValuePairs(slots),
                confirmationStatus, withBotDetails(botName, botAlias, botVersion), userId,
                inputTranscript, invocationSource, outputDialogMode, messageVersion,
                withKeyValuePairs(sessionAttributes),additional);
    }
}
