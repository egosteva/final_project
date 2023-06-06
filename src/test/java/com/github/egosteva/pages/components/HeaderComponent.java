package com.github.egosteva.pages.components;

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

public class HeaderComponent {
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

    public HeaderComponent checkCompanyLogo() {
        companyLogo.shouldBe(visible);

        return this;
    }

    public HeaderComponent checkHeaderItemsInRussian() {
        headerMenuItems.shouldHave(texts(RU_HEADER_ITEMS));

        return this;
    }

    public HeaderComponent checkHeaderItemsInEnglish() {
        headerMenuItems.shouldHave(texts(EN_HEADER_ITEMS));

        return this;
    }

    public HeaderComponent switchLanguageToEnglish() {
        switchLanguageTab.$(byText("EN")).click();

        return this;
    }

    public HeaderComponent switchLanguageToRussian() {
        switchLanguageTab.$(byText("RU")).click();

        return this;
    }

    public HeaderComponent openAboutCompanyHover() {
        aboutCompanySection.hover();

        return this;
    }

    public HeaderComponent checkWhatIsVkTabAppears() {
        whatIsVkTab.shouldBe(visible);

        return this;
    }

    public HeaderComponent checkEducationTabAppears() {
        educationTab.shouldBe(visible);

        return this;
    }

    public HeaderComponent checkContactsTabAppears() {
        contactsTab.shouldBe(visible);

        return this;
    }

    public HeaderComponent openContactsPageLink() {
        contactsTab.click();

        return this;
    }

    public HeaderComponent clickSearchIcon() {
        searchIcon.click();

        return this;
    }

    public HeaderComponent openProjectsPageLink() {
        projectsSection.click();

        return this;
    }
}
