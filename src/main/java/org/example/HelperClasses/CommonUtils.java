package org.example.HelperClasses;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CommonUtils {
    private final SelenideElement cssCookiePopUp = $(By.id("CybotCookiebotDialog"));
    private final SelenideElement cssAllowAllCookiesButton = $(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
    private SelenideElement cssSearchBar = $(By.cssSelector(".form-control.form-control-sm"));
    private SelenideElement cssSearchBarPopup = $(By.cssSelector(".form-control.form-control-lg"));


    protected void searchFor(String textToSearch) {
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

    protected void waitForElementToBeHidden(SelenideElement element) {
        element.shouldBe(hidden, Duration.ofSeconds(3));
    }

    protected void selectFromDropdown(ElementsCollection elementsCollection, String dropdownValue) {
        elementsCollection.findBy(value(dropdownValue)).click();

    }


}
