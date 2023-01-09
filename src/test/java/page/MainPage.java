package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public final static String WELCOME_BANNER_TEXT_RUS = "Безграничные возможности монетизации традиционных и новых цифровых услуг";
    public final static String WELCOME_BANNER_TEXT_ENG = "Advanced monetization on a single convergent platform";
    private final SelenideElement
            welcomeBannerText = $(".welcome-banner__content-subtitle"),
            clientPortalLogo = $(".logo-client"),
            searchInHeaderControls = $(".header__search "),
            searchTextInput = $("[id=edit-search-api-fulltext]"),
            searchLink = $(".line-group-search"),
            searchTextCheck = $(".page-content"),
            languageInHeaderControls = $(".language"),
            clientInHeaderControls = $(".header__client"),
            partWorldSwitch = $(".part-world__switch"),
            inTouchButton = $(".get-in-touch__button"),
            inTouchPopup = $(".get-in-touch__popup");

    private final ElementsCollection menuItems = $$(".menu-item ");

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
        switchTo().window(1);
        return this;
    }

    public MainPage checkClientPortalText() {
        clientPortalLogo.shouldHave(text("Client"));
        return this;
    }

    public MainPage clickItemInMainMenu(String menuItem) {
        menuItems.findBy(text(menuItem)).click();
        return this;
    }

    public MainPage clickPartWorldSwitch() {
        partWorldSwitch.click();
        return this;
    }

    public MainPage clickInTouchButton() {
        inTouchButton.click();
        return this;
    }

    public MainPage checkInTouchPopup(String inTouchPopupTitle) {
        inTouchPopup.shouldHave(text(inTouchPopupTitle));
        return this;
    }
}
