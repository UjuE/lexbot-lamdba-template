package com.ujuezeoke.bot.template.model.request;

/**
 * Created by Obianuju Ezeoke on 10/06/2017.
 */
public class Bot {
    private String name;
    private String alias;
    private String version;

    //For Jackson
    @SuppressWarnings("unused")
    public Bot() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
