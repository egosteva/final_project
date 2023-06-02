package com.github.egosteva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;


public class MainPageTests extends TestBase {
    @BeforeEach
    public void openMainPage() {
        open(baseUrl);
    }

    @Test
    void logoShouldBeVisibleTest() {
        $("[src='/static/common_header/img/vk-group-logo.svg']").shouldBe(visible);
    }

    @Test
    void headerShouldContainItemsTest() {
        List<String> enHeaderItems = List.of("About us", "Our projects", "For business", "For media", "Investor relations", "ESG");
        List<String> ruHeaderItems = List.of("О компании", "Проекты", "Для бизнеса", "Карьера", "Прессе", "Инвесторам", "ESG", "События");

        $$(".header__menu-list .header__menu-item").shouldHave(texts(ruHeaderItems));
        $(".header__change-language_burget_container").$(byText("EN")).click();
        $$(".header__menu-list .header__menu-item").shouldHave(texts(enHeaderItems));
        $(".header__change-language_burget_container").$(byText("RU")).click();
        $$(".header__menu-list .header__menu-item").shouldHave(texts(ruHeaderItems));
    }

    @Test
    void checkHoverAboutCompanyTest() {
        $$(".header__menu-list .header__menu-item").findBy(text("О компании")).hover();
        $(withTagAndText("a", "Что такое VK")).shouldBe(visible);
        $(withTagAndText("a", "Образование")).shouldBe(visible);
        $(withTagAndText("a", "Контакты")).shouldBe(visible);
    }

    @Test
    void checkSearchResultsTest() {
        String searchWord = "java";

        $(".header-icon-search").click();
        webdriver().shouldHave(currentFrameUrl(baseUrl + "/ru/search/"));
        $("[placeholder='Поиск']").shouldBe(visible);
        $("[placeholder='Поиск']").sendKeys(searchWord);
        $(".SearchPage_searchList__5Azac").shouldHave(text(searchWord));
    }
}
