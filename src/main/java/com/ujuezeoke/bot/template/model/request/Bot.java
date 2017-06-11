package com.ujuezeoke.bot.template.model.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class Bot {
    private final String name;
    private final String alias;
    private final String version;

    //For Jackson
    @SuppressWarnings("unused")
    public Bot(String name, String alias, String version) {
        this.name = name;
        this.alias = alias;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public static Bot from(HashMap<String, Object> lexBotRequest) {
        final Map<String, Object> bot = (Map<String, Object>) lexBotRequest.get("bot");
        final String name = Optional.ofNullable(bot.get("name")).map(Object::toString).orElse(null);
        final String alias = Optional.ofNullable(bot.get("alias")).map(Object::toString).orElse(null);
        final String version = Optional.ofNullable(bot.get("version")).map(Object::toString).orElse(null);
        return new Bot(name, alias, version);
    }
}
