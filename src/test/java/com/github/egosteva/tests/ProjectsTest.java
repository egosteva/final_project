package com.github.egosteva.tests;

import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.ProjectsPage;
import com.github.egosteva.pages.components.HeaderComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Проверка работы сайта VK company")
@Owner("egosteva")
@Feature("UI тесты на проверку содержания разделов сайта VK company")
@DisplayName("Проверка страницы 'Проекты'")
@Tag("projects_page_test")
public class ProjectsTest extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderComponent headerComponent = new HeaderComponent();
    ProjectsPage projectsPage = new ProjectsPage();

    @Test
    @DisplayName("Проверка содержания раздела 'Проекты'")
    void checkProjectsSectionContentTest() {
        step("Открыть главную страницу", () ->
                mainPage.openMainPageWithRuAlias());
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