package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static page.MainPage.WELCOME_BANNER_TEXT_ENG;
import static page.MainPage.WELCOME_BANNER_TEXT_RUS;

@Feature("Проверка панели элементов на главной станице сайта")
@Owner("FkkfRf")
@Link(url = "https://nexign.com/ru")
public class HeaderControlsTest extends BaseTest {
    private final static String searchText = "мегафон";
    MainPage mainPage = new MainPage();

    @DisplayName("Проверка поиска по сайту")
    @Test
    void searchFromSiteTest() {
        mainPage.openPage();
        mainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        mainPage.clickSearchInHeaderControls();
        mainPage.searchTextSetValue(searchText);
        mainPage.openSearchLink();
        mainPage.searchTextCheck(searchText);
    }

    @DisplayName("Проверка переключения языка")
    @Test
    void selectLanguageTest() {
        mainPage.openPage();
        mainPage.selectLanguageInHeaderControls("ENG");
        mainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_ENG);
        mainPage.selectLanguageInHeaderControls("RUS");
        mainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
    }

    @DisplayName("Проверка перехода в клиентский портал")
    @Test
    void openClientportalTest() {
        mainPage.openPage();
        mainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        mainPage.clickClientInHeaderControls();
        mainPage.checkClientPortalText();
    }
}

