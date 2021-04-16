package ru.mail.at;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/main/resources/config.properties"
})
public interface Props extends Config {
    @Key("yandex.url")
    String yandexUrl();

}
