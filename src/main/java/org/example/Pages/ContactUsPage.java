package org.example.Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.Enums.ContactUsFormFields;
import org.example.HelperClasses.Utils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactUsPage extends Utils {

    protected SelenideElement pageTitle = $(By.cssSelector(".element-headline.text-center"));
    protected SelenideElement cssSubmitForm = $(By.cssSelector("[value='Send Request']"));
    protected ElementsCollection cssCountryField = $$(By.cssSelector("[name='country'] option"));

    protected void addDataToFormFields(ContactUsFormFields field, String textData) {
        $$(".hbspt-form .hs-input").findBy(attribute("name",field.nameValue)).sendKeys(textData);
    }

    protected void addDataToFormFields(String countryName) {
        cssCountryField.findBy(exactText(countryName)).click();

    }

}
