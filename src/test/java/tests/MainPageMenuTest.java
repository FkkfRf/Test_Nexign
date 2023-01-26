package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static page.MainPage.WELCOME_BANNER_TEXT_RUS;

@Feature("Проверка меню 'Контакты' главной станице сайта")
@Owner("FkkfRf")
@Link(url = "https://nexign.com/ru")
public class MainPageMenuTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @DisplayName("Проверка списка региональных контактов ")
    @Test
    void regionContactsListTest() {
        mainPage.openPage();
        mainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        mainPage.clickItemInMainMenu("Контакты");
        mainPage.clickPartWorldSwitch();
        mainPage.checkPartWorldCityVisible();
    }

    @DisplayName("Проверка нажатия кнопки  'Связаться с нами'")
    @Test
    void openPopupFormTest() {
        mainPage.openPage();
        mainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        mainPage.clickInTouchButton();
        mainPage.checkInTouchPopup("Как мы можем помочь?");
    }
}
