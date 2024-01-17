package org.example.Pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.Enums.ContactUsFormFields;
import org.example.HelperClasses.Utils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactUsPage extends Utils {

    private SelenideElement pageTitle = $(By.cssSelector(".element-headline.text-center"));
    private SelenideElement cssSubmitForm = $(By.cssSelector("[value='Send Request']"));
    private ElementsCollection cssCountryField = $$(By.cssSelector("[name='country'] option"));

    private ElementsCollection cssFormFields = $$(".hbspt-form .hs-input");

    protected void addDataToFormFields(ContactUsFormFields field, String textData) {
        cssFormFields.findBy(attribute("name", field.nameValue)).sendKeys(textData);
    }

    protected void addDataToFormFields(String countryName) {
        cssCountryField.findBy(exactText(countryName)).click();

    }

    protected String getPageTitleText() {
        return pageTitle.shouldBe(visible).getText();
    }

    protected void submitForm() {
        cssSubmitForm.pressEnter();
    }

    protected boolean hasTextInFormField(ContactUsFormFields field) {
        return !cssFormFields.findBy(attribute("name", field.nameValue)).getValue().isEmpty();
    }

    protected String getFieldErrorMessage(ContactUsFormFields field) {
        submitForm();
        return cssFormFields.findBy(attribute("name",field.nameValue)).ancestor(".input").sibling(0).getText();

    }

}
