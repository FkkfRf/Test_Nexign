package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class CareerPage {
    private final SelenideElement contentText = $(".header-new__content"),
            careerCityName = $(byCssSelector(".select2")),
            careerCityCardTitle = $(".vacancy-card__suptitle");
    private final ElementsCollection
            headerMenuItems = $$(".header-new__list-item");

    @Step("Открываем сайт Nexign Career")
    public CareerPage openPage() {
        open("https://job.nexign.com");
        return this;
    }

    @Step("Проверяем наличие текста '{0}' на открытой странице")
    public CareerPage checkCareerContentText(String careerContentText) {
        contentText.shouldHave(text(careerContentText));
        return this;
    }

    @Step("Кликаем элемент меню '{0}'")
    public CareerPage clickMenuElement(String nameMenuElement) {
        headerMenuItems.findBy(text(nameMenuElement)).click();
        return this;
    }

    @Step("Проверяем название открывшейся страницы")
    public CareerPage checkHeaderText(String header) {
        $("h1").shouldHave(text(header));
        return this;
    }

    @Step("Устанавливаем в списке город '{0}' для проверки вакансий")
    public CareerPage setCareerCityOptions(String careerCityOptions) {
        careerCityName.selectOptionContainingText(careerCityOptions);
        return this;
    }

    @Step("Проверяем название города '{0}' в карточке с вакансией")
    public CareerPage checkCareerCityCard(String careerCityName) {
        careerCityCardTitle.shouldHave(text(careerCityName));
        return this;
    }

}
