package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public final static String
            WELCOME_BANNER_TEXT_RUS = "Безграничные возможности монетизации традиционных и новых цифровых услуг";
    public final static String
            WELCOME_BANNER_TEXT_ENG = "Advanced monetization on a single convergent platform";
    private final SelenideElement
            welcomeBannerText = $(".welcome-banner__content-subtitle"),
            clientPortalLogo = $(".logo-client"),
            searchInHeaderControls = $(".header__search "),
            searchTextInput = $("[id=edit-search-api-fulltext]"),
            searchLink = $(".line-group-search"),
            searchTextCheck = $(".page-content"),
            languageInHeaderControls = $(".language"),
            clientInHeaderControls = $(".header__client"),
            partWorldSwitch = $("[data-open='Показать региональные контакты']"),
            partWorldCity = $(".part-world__city"),
            inTouchButton = $(".get-in-touch__button"),
            inTouchPopup = $(".get-in-touch__popup");

    private final ElementsCollection menuItems = $$(".menu-item ");

    @Step("Открываем страницу")
    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    @Step("Проверяем соответствие текста на открытой странице")
    public MainPage checkWelcomeBannerText(String welcomeBannerTextSet) {
        welcomeBannerText.shouldHave(text(welcomeBannerTextSet));
        return this;
    }

    @Step("Кликаем по иконке поиска ")
    public MainPage clickSearchInHeaderControls() {
        searchInHeaderControls.click();
        return this;
    }

    @Step("Вводим текст '{0}' в поле поиска ")
    public MainPage searchTextSetValue(String searchText) {
        searchTextInput.setValue(searchText).pressEnter();
        return this;
    }

    @Step("Кликаем ссылку поиска")
    public MainPage openSearchLink() {
        searchLink.click();
        return this;
    }

    @Step("Проеряем, что искомый текст есть на странице")
    public MainPage searchTextCheck(String searchText) {
        searchTextCheck.shouldHave(text(searchText));
        return this;
    }

    @Step("Выбираем язык сайта '{0}'")
    public MainPage selectLanguageInHeaderControls(String selectLanguage) {
        languageInHeaderControls.click();
        $(byText(selectLanguage)).click();
        return this;
    }

    @Step("Кликаем по иконке клиентского портала  ")
    public MainPage clickClientInHeaderControls() {
        clientInHeaderControls.click();
        switchTo().window(1);
        return this;
    }

    @Step("Проверяем, что открылась станица клиентского портала")
    public MainPage checkClientPortalText() {
        clientPortalLogo.shouldHave(text("Client"));
        return this;
    }

    @Step("Кликаем по пункту меню '{0}'")
    public MainPage clickItemInMainMenu(String menuItem) {
        menuItems.findBy(text(menuItem)).click();
        return this;
    }

    @Step("Кликаем по переключателю 'Показать региональные контакты'")
    public MainPage clickPartWorldSwitch() {
        partWorldSwitch.click();
        return this;
    }

    @Step("Проверяем отображение списка контактов")
    public MainPage checkPartWorldCityVisible() {
        partWorldSwitch.shouldBe(visible);
        return this;
    }

    @Step("Кликаем по кнопке 'Связаться с нами' ")
    public MainPage clickInTouchButton() {
        inTouchButton.click();
        return this;
    }

    @Step("Провряем, что появилось всплывающее окно '{0}'")
    public MainPage checkInTouchPopup(String inTouchPopupTitle) {
        inTouchPopup.shouldHave(text(inTouchPopupTitle));
        return this;
    }
}
