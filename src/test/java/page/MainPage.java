package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final static String WELCOME_BANNER_TEXT = "Безграничные возможности монетизации традиционных и новых цифровых услуг ";
    private final static SelenideElement
            welcomeBannerText = $(".welcome-banner__content-subtitle"),
            searchInHeaderControls = $(".header__search "),
            searchTextInput = $("[id=edit-search-api-fulltext]");

    public MainPage openPage() {
        open(baseUrl);
        welcomeBannerText.shouldHave(text(WELCOME_BANNER_TEXT));
        return this;
    }

    public MainPage clickSearchInHeaderControls() {
        searchInHeaderControls.click();
        return this;
    }

    public MainPage searchTextSetValue(String searchTextSet) {
        searchTextInput.setValue(searchTextSet);
        return this;
    }

}
