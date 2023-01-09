package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class CareerPage {
    private final SelenideElement contentText = $(".header-new__content"),
            careerCityName = $(byCssSelector(".select2")),
            careerCityCardTitle = $(".vacancy-card__suptitle");
    private final ElementsCollection headerMenuItems = $$(".header-new__list-item");

    public CareerPage openPage() {
        open(baseUrl.replace("nexign.com/ru", "job.nexign.com"));
        return this;
    }

    public CareerPage checkCareerContentText(String careerContentText) {
        contentText.shouldHave(text(careerContentText));
        return this;
    }

    public CareerPage clickMenuElement(String nameMenuElement) {
        headerMenuItems.findBy(text(nameMenuElement)).click();
        return this;
    }

    public CareerPage setCareerCityOptions(String careerCityOptions) {
        careerCityName.selectOptionContainingText(careerCityOptions);
        return this;
    }

    public CareerPage checkCareerCityCard(String careerCityName) {
        careerCityCardTitle.shouldHave(text(careerCityName));
        return this;
    }

}
