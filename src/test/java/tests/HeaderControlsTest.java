package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

public class HeaderControlsTest extends BaseTest {
    private final static String WELCOME_BANNER_TEXT_RUS = "Безграничные возможности монетизации традиционных и новых цифровых услуг";
    private final static String WELCOME_BANNER_TEXT_ENG = "Advanced monetization on a single convergent platform";
    private final static String searchText = "мегафон";
    MainPage MainPage = new MainPage();

    @Feature("Проверка панели элементов")
    @DisplayName("Проверка поиска по сайту")
    @Owner("FkkfRf")
    @Link(url = "https://nexign.com/ru")
    @Test
    void searchFromSiteTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        });
        step("Кликаем по иконке поиска ", () -> {
            MainPage.clickSearchInHeaderControls();
        });
        step("Вводим текст в поле поиска", () -> {
            MainPage.searchTextSetValue(searchText);
        });
        step("Переходим по первой ссылке", () -> {
            MainPage.openSearchLink();
        });
        step("Проеряем, что такой текст есть на странице", () -> {
            MainPage.searchTextCheck(searchText);
        });
    }


    @Feature("Проверка панели элементов")
    @DisplayName("Проверка переключения языка")
    @Owner("FkkfRf")
    @Link(url = "https://nexign.com/ru")
    @Test
    void selectLanguageTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
        });
        step("Выбираем язык сайта ENG ", () -> {
            MainPage.selectLanguageInHeaderControls("ENG");
        });
        step("Проверям, что язык установлен  ENG ", () -> {
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_ENG);
        });
        step("Выбираем язык сайта RUS ", () -> {
            MainPage.selectLanguageInHeaderControls("RUS");
        });
        step("Проверям, что язык установлен  RUS ", () -> {
            sleep(3000);
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        });
    }
}

