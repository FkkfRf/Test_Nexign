package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import page.MainPage;
import static io.qameta.allure.Allure.step;

public class SearchTest extends BaseTest {
    page.MainPage MainPage = new MainPage();

    @Feature("Главная страница сайта")
    @Story("Проверка поиска по сайту")
    @Owner("FkkfRf")
    @Link(url = "https://nexign.com/ru")
    @Test
    void searchFromSiteTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
        });
        step("Кликаем по иконке поиска ", () -> {
            MainPage.clickSearchInHeaderControls();
        });
        step("Вводим текст для поиска", () -> {
            MainPage.searchTextSetValue("Мегафон");
        });
    }

}