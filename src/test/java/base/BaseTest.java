package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.qameta.allure.Allure.step;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        ProjectProvider.configBase();
        step("Устанавливаем интеграцию с Selenide", () ->
                SelenideLogger.addListener("AllureSelenide", new AllureSelenide()));
        step("Устанавливаем конфигурацию", () -> {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Selenide.clearBrowserCookies();
        });

    }

    @AfterEach
    void addAttachments() {
        step("прикрепляем логи и отчеты выполнения", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        });
        step("закрываем браузер и вебдрайвер", () -> {
            Selenide.clearBrowserCookies();
            Selenide.closeWindow();
            Selenide.closeWebDriver();
        });
    }

}

