package com.github.egosteva.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.egosteva.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends TestBase {
    private final String RU_ALIAS = "/ru";
    private final SelenideElement
            videoBanner = $("[src='https://vk.company/data/main-video-1280-1.mp4']"),
            welcomeSection = $(".system"),
            projectsSection = $(".projects"),
            promoSection = $(".promo"),
            productsSection = $(".products"),
            pressSection = $(".press");

    public MainPage openMainPageWithRuAlias() {
        open(baseUrl + RU_ALIAS);

        return this;
    }

    public MainPage checkVideoBanner() {
        videoBanner.shouldBe(visible);

        return this;
    }

    public MainPage checkWelcomeSection() {
        welcomeSection.shouldBe(visible);

        return this;
    }

    public MainPage checkProjectsSection() {
        projectsSection.shouldBe(visible);

        return this;
    }

    public MainPage checkPromoSection() {
        promoSection.shouldBe(visible);

        return this;
    }

    public MainPage checkProductsSection() {
        productsSection.shouldBe(visible);

        return this;
    }

    public MainPage checkPressSection() {
        pressSection.shouldBe(visible);

        return this;
    }
}