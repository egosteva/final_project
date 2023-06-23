package com.github.egosteva.tests;

import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.components.HeaderComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Проверка работы сайта VK company")
@Owner("egosteva")
@Feature("UI тесты на проверку содержания разделов сайта VK company")
@DisplayName("Проверка главной страницы")
@Tag("main_page_test")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderComponent headerComponent = new HeaderComponent();

    @BeforeEach
    public void openMainPage() {
        step("Открыть главную страницу", () ->
                mainPage.openMainPageWithRuAlias());
    }

    @Test
    @DisplayName("Проверка содержания главной страницы")
    void mainPageContentTest() {
        step("Проверить отображение логотипа компании", () ->
                headerComponent.checkCompanyLogo());
        step("Проверить наличие разделов в хедере", () ->
                headerComponent.checkHeaderItemsInRussian());
        step("Проверить наличие видео-баннера", () ->
                mainPage.checkVideoBanner());
        step("Проверить наличие секции 'Приветствие'", () ->
                mainPage.checkWelcomeSection());
        step("Проверить наличие секции 'Проекты'", () ->
                mainPage.checkProjectsSection());
        step("Проверить наличие секции 'Статьи'", () ->
                mainPage.checkPromoSection());
        step("Проверить наличие секции 'Продукты'", () ->
                mainPage.checkProductsSection());
        step("Проверить наличие секции 'Пресс-релизы'", () ->
                mainPage.checkPressSection());
    }

    @Test
    @DisplayName("Названия разделов в хедере корректны при переключении языка")
    void headerShouldContainItemsTest() {
        step("Переключить язык на английский", () ->
                headerComponent.switchLanguageToEnglish());
        step("Проверить отображение разделов на английском", () ->
                headerComponent.checkHeaderItemsInEnglish());
        step("Переключить язык на русский", () ->
                headerComponent.switchLanguageToRussian());
        step("Проверить отображение разделов на русском", () ->
                headerComponent.checkHeaderItemsInRussian());
    }

    @Test
    @DisplayName("Проверка содержания всплывающего окна 'О компании'")
    void checkHoverAboutCompanyContentTest() {
        step("Навести курсор на название раздела 'О компании'", () ->
                headerComponent.openAboutCompanyHover());
        step("Проверить, что всплывающее окно содержит табы 'Что такое VK', " +
                "'Образование', 'Контакты'", () -> {
            headerComponent.checkWhatIsVkTabAppears();
            headerComponent.checkEducationTabAppears();
            headerComponent.checkContactsTabAppears();
        });
    }
}