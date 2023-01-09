package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static io.qameta.allure.Allure.step;
import static page.MainPage.WELCOME_BANNER_TEXT_ENG;
import static page.MainPage.WELCOME_BANNER_TEXT_RUS;

public class HeaderControlsTest extends BaseTest {
    private final static String searchText = "мегафон";
    MainPage MainPage = new MainPage();

    @Feature("Проверка панели элементов на главной станице сайта")
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

    @Feature("Проверка панели элементов на главной станице сайта")
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
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        });
    }

    @Feature("Проверка панели элементов на главной станице сайта")
    @DisplayName("Проверка перехода в клиентский портал")
    @Owner("FkkfRf")
    @Link(url = "https://nexign.com/ru")
    @Test
    void openClientportalTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        });
        step("Кликаем по иконке клиентского портала  ", () -> {
            MainPage.clickClientInHeaderControls();
        });
        step("Проверяем, что открылась станица клиентского портала", () -> {
            MainPage.checkClientPortalText();
        });
    }
}

