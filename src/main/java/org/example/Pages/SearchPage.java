package org.example.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.HelperClasses.CommonUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends CommonUtils {


    private ElementsCollection cssListOfArticles = $$(By.cssSelector("#kesearch_results a"));
    private SelenideElement cssSearchResultsNumber = $(By.id("kesearch_num_results"));
    private ElementsCollection cssFilterField = $$(By.cssSelector("#filter_9 option"));
    private SelenideElement cssFindButton = $(By.cssSelector("[value='Find']"));


    protected void selectFromFilterField(String dropdownValue) {
        selectFromDropdown(cssFilterField, dropdownValue);
    }
    protected void find() {
        cssFindButton.click();
    }
    protected String getSearchResultsNumber() {
        return cssSearchResultsNumber.getText().substring(0,1);
    }

    protected String getNumberOfItemsInResults() {
        return String.valueOf(cssListOfArticles.size());

    }



}
