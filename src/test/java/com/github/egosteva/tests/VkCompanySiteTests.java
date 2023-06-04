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
        open(baseUrl);
    }


    @Test
    @DisplayName("На главной странице отображается логотип компании")
    void logoShouldBeVisibleTest() {
        mainPage.checkCompanyLogo();
    }

    @Test
    @DisplayName("Хедер содержит корректные разделы при переключении языка")
    void headerShouldContainItemsTest() {
        mainPage.checkHeaderItemsInRussian();
        mainPage.switchLanguageToEnglish();
        mainPage.checkHeaderItemsInEnglish();
        mainPage.switchLanguageToRussian();
        mainPage.checkHeaderItemsInRussian();
    }

    @Test
    @DisplayName("Проверка содержания всплывающего окна 'О компании'")
    void checkHoverAboutCompanyContentTest() {
        mainPage.openAboutCompanyHover();
        mainPage.checkWhatIsVkTabAppears();
        mainPage.checkEducationTabAppears();
        mainPage.checkContactsTabAppears();
    }

    @Test
    @DisplayName("Проверка наличия локации 'Москва' в списке офисов")
    void checkOfficeLocationTest() {
        String officeLocation = "Москва";

        mainPage.openAboutCompanyHover();
        mainPage.openContactsPageLink();
        contactsPage.checkContactsPageUrl();
        contactsPage.checkOfficeLocationIsAvailableInContactsList(officeLocation);
    }

    @Test
    @DisplayName("Результат поиска содержит слово поисквго запроса")
    void checkSearchResultsTest() {
        String searchText = "java";

        mainPage.openSearchForm();
        searchPage.checkSearchPageUrl();
        searchPage.typeSearchText(searchText);
        searchPage.checkSearchResult(searchText);
    }

    @Test
    @DisplayName("Проверка содержания раздела 'Проекты'")
    void checkProjectsSectionContentTest() {
        mainPage.openProjectsPageLink();
        projectsPage.checkProjectsPageUrl();
        projectsPage.checkHeaderTitle();
        projectsPage.checkProjectGroupsOnTabs();

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
    }
}