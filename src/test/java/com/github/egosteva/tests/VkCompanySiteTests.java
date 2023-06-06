package com.github.egosteva.tests;

import com.github.egosteva.pages.ContactsPage;
import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.ProjectsPage;
import com.github.egosteva.pages.SearchPage;
import com.github.egosteva.pages.components.HeaderComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@Story("Проверка работы сайта VK company")
@Owner("egosteva")
@Feature("UI тесты на проверку содержания разделов сайта VK company")
@DisplayName("Проверка содержания разделов сайта")
public class VkCompanySiteTests extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderComponent headerComponent = new HeaderComponent();
    ContactsPage contactsPage = new ContactsPage();
    SearchPage searchPage = new SearchPage();
    ProjectsPage projectsPage = new ProjectsPage();

    @BeforeEach
    public void openMainPage() {
        step("Открыть главную страницу", () ->
                mainPage.openMainPageWithRuAlias());
    }

    @Test
    @DisplayName("Проверка содержания главной страницы")
    @Tag("main_page_test")
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
    @Tag("main_page_test")
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
    @Tag("main_page_test")
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

    @DisplayName("В списке офисов присутствует локация")
    @ValueSource(strings = {"Москва", "Санкт-Петербург"})
    @Tag("contacts_test")
    @ParameterizedTest(name = "{0}")
    void checkOfficeLocationTest(String officeLocation) {
        step("Навести курсор на название раздела 'О компании'", () ->
                headerComponent.openAboutCompanyHover());
        step("Во всплывающем окне нажать таб 'Контакты'", () ->
                headerComponent.openContactsPageLink());
        step("Проверить url страницы 'Контакты'", () ->
                contactsPage.checkContactsPageUrl());
        step("Проверить, что локация есть в списке офисов", () ->
                contactsPage.checkOfficeLocationIsAvailableInContactsList(officeLocation));
    }

    @Test
    @DisplayName("Результат поиска содержит текст поискового запроса")
    @Tag("search_test")
    void checkSearchResultsTest() {
        String searchText = "java";

        step("Кликнуть на иконку 'Поиск'", () ->
                headerComponent.clickSearchIcon());
        step("Проверить url страницы 'Поиск'", () ->
                searchPage.checkSearchPageUrl());
        step("Ввести текст в поисковую строку", () ->
                searchPage.typeSearchText(searchText));
        step("Проверить, что результат содержит текст запроса", () ->
                searchPage.checkSearchResult(searchText));
    }

    @Test
    @DisplayName("Проверка содержания раздела 'Проекты'")
    @Tag("projects_page_test")
    void checkProjectsSectionContentTest() {
        step("Кликнуть на радел 'Проекты'", () ->
                headerComponent.openProjectsPageLink());
        step("Проверить url страницы 'Проекты'", () ->
                projectsPage.checkProjectsPageUrl());
        step("Проверить название хедера", () ->
                projectsPage.checkHeaderTitle());
        step("Проверить наличие табов с группами проектов", () ->
                projectsPage.checkProjectGroupsOnTabs());
        step("Проверить наличие секций - групп проектов", () -> {
            projectsPage
                    .checkSocialSectionTitle()
                    .checkEntertainmentSectionTitle()
                    .checkEducationSectionTitle()
                    .checkProductivitySectionSectionTitle()
                    .checkAppStoreSectionSectionTitle()
                    .checkGamesSectionSectionTitle()
                    .checkDevicesSectionSectionTitle()
                    .checkMessengersSectionSectionTitle()
                    .checkSocialServicesSectionSectionTitle()
                    .checkGoodsSectionSectionTitle()
                    .checkEcosystemSectionSectionTitle();
        });
    }
}