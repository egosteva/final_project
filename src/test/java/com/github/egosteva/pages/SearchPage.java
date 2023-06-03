package com.github.egosteva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class SearchPage {
    private final String SEARCH_URL = "/ru/search/";
    private final SelenideElement
            searchPlaceholder = $("[placeholder='Поиск']"),
            searchResultsList = $(".SearchPage_searchList__5Azac");

    public SearchPage checkSearchPageUrl() {
        webdriver().shouldHave(currentFrameUrl(baseUrl + SEARCH_URL));

        return this;
    }

    public SearchPage searchPlaceholder() {
        webdriver().shouldHave(currentFrameUrl(baseUrl + SEARCH_URL));

        return this;
    }

    public SearchPage typeSearchText(String value) {
        searchPlaceholder.sendKeys(value);

        return this;
    }

    public SearchPage checkSearchResult(String value) {
        searchResultsList.shouldHave(text(value));

        return this;
    }
}