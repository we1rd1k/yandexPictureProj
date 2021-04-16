package ru.mail.at.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru/mail/at/stepdef",
        plugin = "pretty"
)
public class TestRunner {
}
