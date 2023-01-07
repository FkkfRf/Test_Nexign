package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final static SelenideElement
            welcomeBannerText = $(".welcome-banner__content-subtitle"),
            clientPortalText = $(".portal-name"),
            searchInHeaderControls = $(".header__search "),
            searchTextInput = $("[id=edit-search-api-fulltext]"),
            searchLink = $(".line-group-search"),
            searchTextCheck = $(".page-content"),
            languageInHeaderControls = $(".language"),
            clientInHeaderControls = $(".header__client");


    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    public MainPage checkWelcomeBannerText(String welcomeBannerTextSet) {
        welcomeBannerText.shouldHave(text(welcomeBannerTextSet));
        return this;
    }

    public MainPage clickSearchInHeaderControls() {
        searchInHeaderControls.click();
        return this;
    }

    public MainPage searchTextSetValue(String searchText) {
        searchTextInput.setValue(searchText).pressEnter();
        return this;
    }

    public MainPage openSearchLink() {
        searchLink.click();
        return this;
    }

    public MainPage searchTextCheck(String searchText) {
        searchTextCheck.shouldHave(text(searchText));
        return this;
    }

    public MainPage selectLanguageInHeaderControls(String selectLanguage) {
        languageInHeaderControls.click();
        $(byText(selectLanguage)).click();
        return this;
    }
    public MainPage clickClientInHeaderControls() {
        clientInHeaderControls.click();
        return this;
    }
    public MainPage checkClientPortalText() {
        clientPortalText.shouldHave(text("Клиентский портал АО «Нэксайн»"));
        return this;
    }
}
