package ru.mail.at.stepdef;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.mail.at.stepdef.BaseStep.getImage;

@Slf4j
public class StepDefYandexImagePage {

    @То("Проверяем, что находимся на странцу для поиска картинок")
    public void проверяемЧтоНаходимсяНаСтранцуДляПоискаКартинок() {
        log.info("Проверяем, что находимся на странцу для поиска картинок");
        $x("//div[contains(@class, 'tabs-navigation')]//div[text()='Картинки']/parent::a")
                .shouldBe(visible)
                .shouldBe(attribute("aria-disabled", "true"));
        assertTrue(WebDriverRunner.url().contains("/images/"));
    }

    @Когда("Кликаем по кнопке Поиск по изображению")
    public void кликаемПоКнопкеПоискПоИзображению() {
        log.info("Кликаем по кнопке Поиск по изображению");
        $x("//button[@aria-label='Поиск по изображению']").click();
    }

    @Тогда("Проверяем, что появился ToolBar для вставки изображения")
    public void проверяемЧтоПоявилсяToolBarДляВставкиИзображения() {
        log.info("Проверяем, что появился ToolBar для вставки изображения");
        $x("//button[text()='Выберите файл']").shouldBe(visible);
    }

    @Когда("Когда загружаем картинку для поиска")
    public void когдаЗагружаемКартинкуДляПоиска() {
        log.info("Когда загружаем картинку {} для поиска", getImage().get());
        $x("//input[@type='file']").uploadFile(new File("src\\test\\resources\\images\\" + getImage().get() + ".jpg"));
    }

    @И("Кликаем по кнопке найти")
    public void кликаемПоКнопкеНайти() {
    }

    @Тогда("Проверяем, что в блоке \"Кажется на изображении есть\" присутствует название изображения")
    public void проверяем() {
        log.info("Проверяем, что в блоке \"Кажется на изображении есть\" присутствует слово");
        $x("//div[text()='Кажется, на изображении']").waitUntil(visible, 7000);
        assertTrue($$x("//div[text()='Кажется, на изображении']/following-sibling::div//a/span").texts()
                .stream().anyMatch(x -> x.matches("^.*" + getImage().get() + ".*$")), getImage().get() + " отсутсвует в блоке");
    }
}
