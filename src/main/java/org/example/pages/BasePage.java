package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private static final SelenideElement cssCookiePopUp = $(By.id("CybotCookiebotDialog"));
    private static final SelenideElement cssAllowAllCookiesButton = $(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
    private static final SelenideElement cssSearchBar = $(By.cssSelector(".form-control.form-control-sm"));
    private static final SelenideElement cssSearchBarPopup = $(By.cssSelector(".form-control.form-control-lg"));


    public void searchFor(String textToSearch) {
        cssSearchBar.click();
        cssSearchBarPopup.val(textToSearch).pressEnter();
    }

    public void allowCookies() {
        if (cssCookiePopUp.isDisplayed()) {
            cssAllowAllCookiesButton.click();
            waitForElementToBeHidden(cssCookiePopUp);
        }
    }

    protected void waitForElementToBeVisible(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(3));
    }

    protected static void waitForElementToBeHidden(SelenideElement element) {
        element.shouldBe(hidden, Duration.ofSeconds(3));
    }

    protected void selectFromDropdown(ElementsCollection elementsCollection, String dropdownValue) {
        elementsCollection.findBy(value(dropdownValue)).click();

    }


}
