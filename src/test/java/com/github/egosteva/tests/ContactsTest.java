package com.github.egosteva.tests;

import com.github.egosteva.pages.ContactsPage;
import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.components.HeaderComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@Story("Проверка работы сайта VK company")
@Owner("egosteva")
@Feature("UI тесты на проверку содержания разделов сайта VK company")
@DisplayName("Проверка страницы 'Контакты'")
@Tag("contacts_test")
public class ContactsTest extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderComponent headerComponent = new HeaderComponent();
    ContactsPage contactsPage = new ContactsPage();

    @DisplayName("В списке офисов присутствует локация")
    @ValueSource(strings = {"Москва", "Санкт-Петербург"})
    @ParameterizedTest(name = "{0}")
    void checkOfficeLocationTest(String officeLocation) {
        step("Открыть главную страницу", () ->
                mainPage.openMainPageWithRuAlias());
        step("Навести курсор на название раздела 'О компании'", () ->
                headerComponent.openAboutCompanyHover());
        step("Во всплывающем окне нажать таб 'Контакты'", () ->
                headerComponent.openContactsPageLink());
        step("Проверить url страницы 'Контакты'", () ->
                contactsPage.checkContactsPageUrl());
        step("Проверить, что локация есть в списке офисов", () ->
                contactsPage.checkOfficeLocationIsAvailableInContactsList(officeLocation));
    }
}