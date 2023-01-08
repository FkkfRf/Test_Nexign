package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.CareerPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CareerPageTest extends BaseTest {
    CareerPage CareerPage = new CareerPage();
    @Feature("Проверка раздела Nexign Career")
    @DisplayName("Проверка перехода по элементам меню")
    @Owner("FkkfRf")
    @Link(url = "https://job.nexign.com/")
    @CsvFileSource(resources = "/parameters/careerMenuSource.csv", numLinesToSkip = 0)
    @ParameterizedTest(name = "Выбран {0}")
    void openPagesFromTopMenuTest(String menuElement, String pageHeader) {
        step("Открываем сайт Nexign Career", () -> {
            CareerPage.openPage();
            CareerPage.checkCareerContentText("Nexign Career");
        });
        step("Кликаем элемент меню", () -> {
            CareerPage.clickMenuElement(menuElement);
        });
        step("Проверяем название открывшейся страницы", () -> {
            $("h1").shouldHave(text(String.valueOf(pageHeader)));
        });
    }
}
