package com.github.egosteva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class ContactsPage {
    private final String CONTACTS_URL = "/ru/company/contacts/";
    private final SelenideElement contactsList = $(".contacts__list");

    public ContactsPage checkContactsPageUrl() {
        webdriver().shouldHave(currentFrameUrl(baseUrl + CONTACTS_URL));

        return this;
    }

    public ContactsPage checkOfficeLocationIsAvailableInContactsList(String value) {
        contactsList.shouldHave(text(value));

        return this;
    }
}