package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class CareerPage {
    private final static SelenideElement
            contentText = $(".header-new__content");

    public CareerPage openPage() {
        open(baseUrl.replace("nexign.com/ru", "job.nexign.com"));
        return this;
    }

    public CareerPage checkCareerContentText(String careerContentText) {
        contentText.shouldHave(text(careerContentText));
        return this;
    }

    public CareerPage clickMenuElement(String nameMenuElement) {
        $$(".header-new__list-item").findBy(text(nameMenuElement)).click();
        return this;
    }
}
