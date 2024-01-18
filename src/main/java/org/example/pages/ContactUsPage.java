package org.example.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.model.ContactUsFormFields;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactUsPage extends BasePage {

    private final SelenideElement pageTitle = $(By.cssSelector(".element-headline.text-center"));
    private final SelenideElement cssSubmitForm = $(By.cssSelector("[value='Send Request']"));
    private final ElementsCollection cssCountryField = $$(By.cssSelector("[name='country'] option"));

    private final ElementsCollection cssFormFields = $$(".hbspt-form .hs-input");

    public void addDataToFormFields(ContactUsFormFields field, String textData) {
        cssFormFields.findBy(attribute("name", field.nameValue)).sendKeys(textData);
    }

    public void addDataToFormFields(String countryName) {
        selectFromDropdown(cssCountryField,countryName);
    }

    public String getPageTitleText() {
        return pageTitle.shouldBe(visible).getText();
    }

    public void submitForm() {
        cssSubmitForm.pressEnter();
    }

    public boolean hasTextInFormField(ContactUsFormFields field) {
        return !cssFormFields.findBy(attribute("name", field.nameValue)).getValue().isEmpty();
    }

    public String getFieldErrorMessage(ContactUsFormFields field) {
        submitForm();
        return cssFormFields.findBy(attribute("name",field.nameValue)).ancestor(".input").sibling(0).getText();

    }

}
