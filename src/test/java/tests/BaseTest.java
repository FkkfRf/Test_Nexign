package tests;

import config.ProjectProvider;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        step("Устанавливаем конфигурацию", () -> {
            ProjectProvider.configBase();
            ProjectProvider.setCapability();
        });
        step("Устанавливаем интеграцию с Selenide", () ->
                ProjectProvider.selenideLogger());
    }

    @AfterEach
    void addAttachments() {
        step("прикрепляем логи и отчеты выполнения", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        });
        closeWebDriver();
    }
}

