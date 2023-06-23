package com.github.egosteva.tests;

import com.github.egosteva.pages.MainPage;
import com.github.egosteva.pages.SearchPage;
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
@DisplayName("Проверка работы поиска")
@Tag("search_test")
public class SearchTest extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderComponent headerComponent = new HeaderComponent();
    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Результат поиска содержит текст поискового запроса")
    void checkSearchResultsTest() {
        String searchText = "java";

        step("Открыть главную страницу", () ->
                mainPage.openMainPageWithRuAlias());
        step("Кликнуть на иконку 'Поиск'", () ->
                headerComponent.clickSearchIcon());
        step("Проверить url страницы 'Поиск'", () ->
                searchPage.checkSearchPageUrl());
        step("Ввести текст в поисковую строку", () ->
                searchPage.typeSearchText(searchText));
        step("Проверить, что результат содержит текст запроса", () ->
                searchPage.checkSearchResult(searchText));
    }
}