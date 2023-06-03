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


public class VkCompanyTests extends TestBase {
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
    void checkMoscowOfficeIsAvailableTest(){
        $$(".header__menu-list .header__menu-item").findBy(text("О компании")).hover();
        $(withTagAndText("a", "Контакты")).click();
        webdriver().shouldHave(currentFrameUrl(baseUrl + "/ru/company/contacts/"));
        $(".contacts__list").shouldHave(text("Москва"));
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

    @Test
    void checkSectionProjectsTest() {
        List<String> projectGroups = List.of("Соцсети", "Медиа и развлечения", "Образование", "Продуктивность",
                "Магазин приложений", "Игры", "Устройства", "Мессенджеры", "Благотворительность", "Товары и услуги", "Экосистемные сервисы");

        $(withTagAndText("a", "Проекты")).click();
        webdriver().shouldHave(currentFrameUrl(baseUrl + "/ru/projects/"));
        $(".PageHeader_pageHeader__content__RQBGx").shouldHave(text("Проекты"));
        $$(".AdaptiveTabs_tabsList__MdFef .AdaptiveTabs_tabsListElement__RWaZI").shouldHave(texts(projectGroups));
        $("#social").shouldHave(text("Соцсети"));
        $("#entertainment").shouldHave(text("Медиа и развлечения"));
        $("#education").shouldHave(text("Образование"));
        $("#productivity").shouldHave(text("Продуктивность"));
        $("#app_store").shouldHave(text("Магазин приложений"));
        $("#games").shouldHave(text("Игры"));
        $("#devices").shouldHave(text("Устройства"));
        $("#messengers").shouldHave(text("Мессенджеры"));
        $("#social_services").shouldHave(text("Благотворительность"));
        $("#goods").shouldHave(text("Товары и услуги"));
        $("#ecosystem").shouldHave(text("Экосистемные сервисы"));
    }
}