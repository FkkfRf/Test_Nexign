package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
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

    @Feature("Проверка раздела Nexign Career job.nexign.com")
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

    @Feature("Проверка раздела Nexign Career job.nexign.com")
    @DisplayName("Проверка выбора региона с вакансиями")
    @Owner("FkkfRf")
    @Link(url = "https://job.nexign.com/")
    @ValueSource(strings = {"Санкт-Петербург", "Москва", "Краснодар", "Самара", "Новосибирск", "Владивосток"})
    @ParameterizedTest(name = "Выбран {0}")
    void careerCitySelectTest(String cityName) {
        step("Открываем сайт Nexign Career", () -> {
            CareerPage.openPage();
            CareerPage.checkCareerContentText("Nexign Career");
        });
        step("Кликаем элемент меню 'Вакансии'", () -> {
            CareerPage.clickMenuElement("Вакансии");
        });
        step("Устанавливаем в списке город для проверки вакансий", () -> {
            CareerPage.setCareerCityOptions(cityName);
        });
        step("Проверяем название города в карточке с вакансией", () -> {
            CareerPage.checkCareerCityCard(cityName);
        });

    }
}
