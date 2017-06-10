package com.ujuezeoke.bot.template.model.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static com.ujuezeoke.bot.template.model.RequestTemplateHelper.lexRequestWith;
import static org.junit.Assert.assertTrue;

/**
 * Created by Obianuju Ezeoke on 09/06/2017.
 */
public class LexBotRequestTest {

    @Test
    public void canBeDeSerializedFromExpectedLexBotRequest() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String src = lexRequestWith(
                "SomeIntent",
                Collections.emptyMap(),
                "None",
                "",
                "",
                "",
                "",
                "",
                "FulfillmentCodeHook",
                "Voice",
                "",
                Collections.emptyMap()
        );

        final Object readValue = objectMapper.reader(LexBotRequest.class)
                .readValue(src);

        assertTrue(readValue.getClass().isAssignableFrom(LexBotRequest.class));
    }

    @Test
    public void canHandleNewElementsIfTheApIChanges() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String src = lexRequestWith(
                "",
                Collections.emptyMap(),
                "Confirmed",
                "",
                "",
                "",
                "",
                "",
                "DialogCodeHook",
                "Text",
                "",
                Collections.emptyMap(),
                ",\"newElement\":5"
        );

        System.out.println("src = " + src);
        final Object readValue = objectMapper.reader(LexBotRequest.class)
                .readValue(src);

        assertTrue(readValue.getClass().isAssignableFrom(LexBotRequest.class));
    }
}
