package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.CareerPage;

@Feature("Проверка раздела Nexign Career job.nexign.com")
@Owner("FkkfRf")
@Link(url = "https://job.nexign.com/")
public class CareerPageTest extends BaseTest {
    CareerPage careerPage = new CareerPage();

    @DisplayName("Проверка перехода по элементам меню")
    @CsvFileSource(resources = "/parameters/careerMenuSource.csv", numLinesToSkip = 0)
    @ParameterizedTest(name = "Выбран  {0}")
    void openPagesFromTopMenuTest(String menuElement, String pageHeader) {
        careerPage.openPage();
        careerPage.checkCareerContentText("Nexign Career");
        careerPage.clickMenuElement(menuElement);
        careerPage.checkHeaderText(pageHeader);
    }

    @DisplayName("Проверка выбора региона с вакансиями")
    @ValueSource(strings = {"Санкт-Петербург", "Москва", "Краснодар", "Самара", "Новосибирск", "Владивосток"})
    @ParameterizedTest(name = "Выбран  {0}")
    void careerCitySelectTest(String cityName) {
        careerPage.openPage();
        careerPage.checkCareerContentText("Nexign Career");
        careerPage.clickMenuElement("Вакансии");
        careerPage.setCareerCityOptions(cityName);
        careerPage.checkCareerCityCard(cityName);
    }
}
