package ru.mail.at;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.qameta.allure.selenide.AllureSelenide;

public class BaseStep {

    private static ThreadLocal<String> image = new ThreadLocal<>();

    @Before
    public static void init() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }

    @After
    public void afterTest() {
        Selenide.closeWebDriver();
    }

    @Дано("Изображение для поиска {string}")
    public void изображениеДляПоиска(String imageName) {
        image.set(imageName);
    }

    public static ThreadLocal<String> getImage() {
        return image;
    }
}
