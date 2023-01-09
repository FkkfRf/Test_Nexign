package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static page.MainPage.WELCOME_BANNER_TEXT_RUS;

public class MainPageMenuTest extends BaseTest {
    MainPage MainPage = new MainPage();

    @Feature("Проверка меню 'Контакты' главной станице сайта")
    @DisplayName("Проверка списка региональных контактов ")
    @Owner("FkkfRf")
    @Link(url = "https://nexign.com/ru")
    @Test
    void regionContactsListTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        });
        step("Кликаем по пункту меню 'Контакты' ", () -> {
            MainPage.clickItemInMainMenu("Контакты");
        });
        step("Кликаем по переключателю 'Показать региональные контакты'", () -> {
            MainPage.clickPartWorldSwitch();
        });
        step("Проверяем отображение списка контактов", () -> {
            MainPage.checkPartWorldCityVisible();
        });
    }

    @Feature("Проверка формы обратной связи на главной станице сайта")
    @DisplayName("Проверка нажатия кнопки  'Связаться с нами'")
    @Owner("FkkfRf")
    @Link(url = "https://nexign.com/ru")
    @Test
    void openPopupFormTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
            MainPage.checkWelcomeBannerText(WELCOME_BANNER_TEXT_RUS);
        });
        step("Кликаем по кнопке 'Связаться с нами' ", () -> {
            $(".eu-cookie-compliance-buttons").click();
            MainPage.clickInTouchButton();
        });
        step("Провряем, что появилось всплывающее окно 'Как мы можем помочь?'", () -> {
            MainPage.checkInTouchPopup("Как мы можем помочь?");
        });
    }
}
