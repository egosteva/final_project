package com.github.egosteva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class ProjectsPage {
    private final String
            PROJECTS_URL = "/ru/projects/",
            HEADER_TITLE = "Проекты",
            SOCIAL_SECTION_TITLE = "Соцсети",
            ENTERTAINMENT_SECTION_TITLE = "Медиа и развлечения",
            EDUCATION_SECTION_TITLE = "Образование",
            PRODUCTIVITY_SECTION_TITLE = "Продуктивность",
            APP_STORE_SECTION_TITLE = "Магазин приложений",
            GAMES_SECTION_TITLE = "Игры",
            DEVICES_SECTION_TITLE = "Устройства",
            MESSENGERS_SECTION_TITLE = "Мессенджеры",
            SOCIAL_SERVICES_SECTION_TITLE = "Благотворительность",
            GOODS_SECTION_TITLE = "Товары и услуги",
            ECOSYSTEM_SECTION_TITLE = "Экосистемные сервисы";
    private final SelenideElement
            header = $(".PageHeader_pageHeader__content__RQBGx"),
            socialSection = $("#social"),
            entertainmentSection = $("#entertainment"),
            educationSection = $("#education"),
            productivitySection = $("#productivity"),
            appStoreSection = $("#app_store"),
            gamesSection = $("#games"),
            devicesSection = $("#devices"),
            messengersSection = $("#messengers"),
            socialServicesSection = $("#social_services"),
            goodsSection = $("#goods"),
            ecosystemSection = $("#ecosystem");

    public ProjectsPage checkProjectsPageUrl() {
        webdriver().shouldHave(currentFrameUrl(baseUrl + PROJECTS_URL));

        return this;
    }

    public ProjectsPage checkHeaderTitle() {
        header.shouldHave(text(HEADER_TITLE));

        return this;
    }

    public ProjectsPage checkSocialSectionTitle() {
        socialSection.scrollIntoView(true);
        socialSection.shouldHave(text(SOCIAL_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkEntertainmentSectionTitle() {
        entertainmentSection.scrollIntoView(true);
        entertainmentSection.shouldHave(text(ENTERTAINMENT_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkEducationSectionTitle() {
        educationSection.scrollIntoView(true);
        educationSection.shouldHave(text(EDUCATION_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkProductivitySectionSectionTitle() {
        productivitySection.scrollIntoView(true);
        productivitySection.shouldHave(text(PRODUCTIVITY_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkAppStoreSectionSectionTitle() {
        appStoreSection.scrollIntoView(true);
        appStoreSection.shouldHave(text(APP_STORE_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkGamesSectionSectionTitle() {
        gamesSection.scrollIntoView(true);
        gamesSection.shouldHave(text(GAMES_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkDevicesSectionSectionTitle() {
        devicesSection.scrollIntoView(true);
        devicesSection.shouldHave(text(DEVICES_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkMessengersSectionSectionTitle() {
        messengersSection.scrollIntoView(true);
        messengersSection.shouldHave(text(MESSENGERS_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkSocialServicesSectionSectionTitle() {
        socialServicesSection.scrollIntoView(true);
        socialServicesSection.shouldHave(text(SOCIAL_SERVICES_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkGoodsSectionSectionTitle() {
        goodsSection.scrollIntoView(true);
        goodsSection.shouldHave(text(GOODS_SECTION_TITLE));

        return this;
    }

    public ProjectsPage checkEcosystemSectionSectionTitle() {
        ecosystemSection.scrollIntoView(true);
        ecosystemSection.shouldHave(text(ECOSYSTEM_SECTION_TITLE));

        return this;
    }
}