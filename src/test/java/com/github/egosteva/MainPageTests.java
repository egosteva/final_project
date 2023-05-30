package com.github.egosteva;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class MainPageTests extends TestBase {

    @Test
    void headerShouldContainItemsTest() {
        List<String> enHeaderItems = List.of("About us","Our projects","For business","For media","Investor relations","ESG");
        List<String> ruHeaderItems = List.of("О компании","Проекты","Для бизнеса","Карьера","Прессе","Инвесторам","ESG","События");

        open(baseUrl);
        $(".header__change-language_burget_container").$(byText("EN")).click();
        $$(".header__menu-list .header__menu-item").shouldHave(texts(enHeaderItems));
        $(".header__change-language_burget_container").$(byText("RU")).click();
        $$(".header__menu-list .header__menu-item").shouldHave(texts(ruHeaderItems));
    }
}
