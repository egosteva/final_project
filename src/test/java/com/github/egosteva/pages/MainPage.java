package com.github.egosteva.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final List<String> EN_HEADER_ITEMS = List.of("About us", "Our projects", "For business", "For media", "Investor relations", "ESG");
    private final List<String> RU_HEADER_ITEMS = List.of("О компании", "Проекты", "Для бизнеса", "Карьера", "Прессе", "Инвесторам", "ESG", "События");
    private final SelenideElement
            companyLogo = $("[src='/static/common_header/img/vk-group-logo.svg']"),
            switchLanguageTab = $(".header__change-language_burget_container"),
            aboutCompanySection = $$(".header__menu-list .header__menu-item").findBy(text("О компании")),
            projectsSection = $(withTagAndText("a", "Проекты")),
            whatIsVkTab = $(withTagAndText("a", "Что такое VK")),
            educationTab = $(withTagAndText("a", "Образование")),
            contactsTab = $(withTagAndText("a", "Контакты")),
            searchIcon = $(".header-icon-search");
    private final ElementsCollection headerMenuItems = $$(".header__menu-list .header__menu-item");

    public MainPage checkCompanyLogo() {
        companyLogo.shouldBe(visible);

        return this;
    }

    public MainPage checkHeaderItemsInRussian() {
        headerMenuItems.shouldHave(texts(RU_HEADER_ITEMS));

        return this;
    }

    public MainPage checkHeaderItemsInEnglish() {
        headerMenuItems.shouldHave(texts(EN_HEADER_ITEMS));

        return this;
    }

    public MainPage switchLanguageToEnglish() {
        switchLanguageTab.$(byText("EN")).click();

        return this;
    }

    public MainPage switchLanguageToRussian() {
        switchLanguageTab.$(byText("RU")).click();

        return this;
    }

    public MainPage openAboutCompanyHover() {
        aboutCompanySection.hover();

        return this;
    }

    public MainPage checkWhatIsVkTabAppears() {
        whatIsVkTab.shouldBe(visible);

        return this;
    }

    public MainPage checkEducationTabAppears() {
        educationTab.shouldBe(visible);

        return this;
    }

    public MainPage checkContactsTabAppears() {
        contactsTab.shouldBe(visible);

        return this;
    }

    public MainPage openContactsPageLink() {
        contactsTab.click();

        return this;
    }

    public MainPage openSearchForm() {
        searchIcon.click();

        return this;
    }

    public MainPage openProjectsPageLink() {
        projectsSection.click();

        return this;
    }
}