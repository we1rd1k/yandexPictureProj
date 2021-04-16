package ru.mail.at.stepdef;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import ru.mail.at.Props;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class StepDefYandexMainPage {

    private static Props props = ConfigFactory.create(Props.class);

    @Когда("Открываем главную страницу Yandex")
    public void открываемГлавнуюСтраницуYandex() {
        log.info("Открываем главную страницу Yandex");
        open(props.yandexUrl());
        $x("//div[contains(@class, 'home-logo')]//div").shouldHave(attribute("aria-label", "Яндекс"));
    }

    @Когда("Кликаем по иконке {string}")
    public void кликаемПоИконке(String iconName) {
        log.info("Кликаем по иконке {}", iconName);
        $x(String.format("//nav//ul//a//div[contains(@class, 'title') and text()='%s']", iconName)).shouldBe(visible).click();
    }

    @И("Переключаемся на окно поиска картинок")
    public void переключаемсяНаОкноПоискаКартинок() {
        switchTo().window("Яндекс.Картинки: поиск изображений в интернете, поиск по изображению");
    }
}
