package com.github.egosteva.tests;

import com.github.egosteva.pages.ContactsPage;
import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.ProjectsPage;
import com.github.egosteva.pages.SearchPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Story("Проверка работы сайта VK company")
@Owner("egosteva")
@Feature("UI тесты на проверку содержания разделов сайта")
@DisplayName("Проверка содержания разделов сайта")
@Tag("ui_test")
public class VkCompanySiteTests extends TestBase {
    MainPage mainPage = new MainPage();
    ContactsPage contactsPage = new ContactsPage();
    SearchPage searchPage = new SearchPage();
    ProjectsPage projectsPage = new ProjectsPage();

    @BeforeEach
    public void openMainPage() {
        step("Открыть главную страницу", () ->
                open(baseUrl));
    }

    @Test
    @DisplayName("На главной странице отображается логотип компании")
    void logoShouldBeVisibleTest() {
        step("Проверить отображение логотипа компании", () ->
                mainPage.checkCompanyLogo());
    }

    @Test
    @DisplayName("Хедер содержит корректные разделы при переключении языка")
    void headerShouldContainItemsTest() {
        step("Проверить наличие разделов в хедере", () ->
                mainPage.checkHeaderItemsInRussian());
        step("Переключить язык на английский", () ->
                mainPage.switchLanguageToEnglish());
        step("Проверить отображение разделов на английском", () ->
                mainPage.checkHeaderItemsInEnglish());
        step("Переключить язык на русский", () ->
                mainPage.switchLanguageToRussian());
        step("Проверить отображение разделов на русском", () ->
                mainPage.checkHeaderItemsInRussian());
    }

    @Test
    @DisplayName("Проверка содержания всплывающего окна 'О компании'")
    void checkHoverAboutCompanyContentTest() {
        step("Навести курсор на название раздела 'О компании'", () ->
                mainPage.openAboutCompanyHover());

        step("Проверить, что всплывающее окно содержит табы 'Что такое VK', " +
                "'Образование', 'Контакты'", () -> {
            mainPage.checkWhatIsVkTabAppears();
            mainPage.checkEducationTabAppears();
            mainPage.checkContactsTabAppears();
        });
    }

    @Test
    @DisplayName("Проверка наличия локации 'Москва' в списке офисов")
    void checkOfficeLocationTest() {
        String officeLocation = "Москва";

        step("Навести курсор на название раздела 'О компании'", () ->
                mainPage.openAboutCompanyHover());
        step("Во всплывающем окне нажать таб 'Контакты'", () ->
                mainPage.openContactsPageLink());
        step("Проверить url страницы 'Контакты'", () ->
                contactsPage.checkContactsPageUrl());
        step("Проверить, что локация 'Москва' есть в списке офисов", () ->
                contactsPage.checkOfficeLocationIsAvailableInContactsList(officeLocation));
    }

    @Test
    @DisplayName("Результат поиска содержит текст поискового запроса")
    void checkSearchResultsTest() {
        String searchText = "java";

        step("Кликнуть на иконку 'Поиск'", () ->
                mainPage.clickSearchIcon());
        step("Проверить url страницы 'Поиск'", () ->
                searchPage.checkSearchPageUrl());
        step("Ввести текст в поисковую строку", () ->
                searchPage.typeSearchText(searchText));
        step("Проверить, что результат содержит текст запроса", () ->
                searchPage.checkSearchResult(searchText));
    }

    @Test
    @DisplayName("Проверка содержания раздела 'Проекты'")
    void checkProjectsSectionContentTest() {
        step("Кликнуть на радел 'Проекты'", () ->
                mainPage.openProjectsPageLink());
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