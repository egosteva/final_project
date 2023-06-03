package com.github.egosteva.tests;

import com.github.egosteva.pages.ContactsPage;
import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.ProjectsPage;
import com.github.egosteva.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;


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
    void logoShouldBeVisibleTest() {
        mainPage.checkCompanyLogo();
    }

    @Test
    void headerShouldContainItemsTest() {
        mainPage.checkHeaderItemsInRussian();
        mainPage.switchLanguageToEnglish();
        mainPage.checkHeaderItemsInEnglish();
        mainPage.switchLanguageToRussian();
        mainPage.checkHeaderItemsInRussian();
    }

    @Test
    void checkHoverAboutCompanyContentTest() {
        mainPage.openAboutCompanyHover();
        mainPage.checkWhatIsVkTabAppears();
        mainPage.checkEducationTabAppears();
        mainPage.checkContactsTabAppears();
    }

    @Test
    void checkOfficeLocationTest() {
        String officeLocation = "Москва";

        mainPage.openAboutCompanyHover();
        mainPage.openContactsPageLink();
        contactsPage.checkContactsPageUrl();
        contactsPage.checkOfficeLocationIsAvailableInContactsList(officeLocation);
    }

    @Test
    void checkSearchResultsTest() {
        String searchText = "java";

        mainPage.openSearchForm();
        searchPage.checkSearchPageUrl();
        searchPage.typeSearchText(searchText);
        searchPage.checkSearchResult(searchText);
    }

    @Test
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