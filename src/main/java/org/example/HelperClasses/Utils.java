package org.example.HelperClasses;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Utils {
    private final SelenideElement cssCookiePopUp = $(By.id("CybotCookiebotDialog"));
    private final SelenideElement cssAllowAllCookiesButton = $(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));


    public void allowCookies(){
        if (cssCookiePopUp.isDisplayed()) {
            cssAllowAllCookiesButton.click();
            waitForElementToBeHidden(cssCookiePopUp);
        }
    }

    protected void waitForElementToBeVisible(SelenideElement element){
        element.shouldBe(visible, Duration.ofSeconds(5));
    }

    protected void waitForElementToBeHidden(SelenideElement element){
        element.shouldBe(hidden, Duration.ofSeconds(5));
    }



}
