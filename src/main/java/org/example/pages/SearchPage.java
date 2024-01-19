package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage {


    private final ElementsCollection cssListOfArticles = $$(By.cssSelector("#kesearch_results a"));
    private final SelenideElement cssSearchResultsNumber = $(By.id("kesearch_num_results"));
    private final ElementsCollection cssFilterField = $$(By.cssSelector("#filter_9 option"));
    private final SelenideElement cssFindButton = $(By.cssSelector("[value='Find']"));


    public void selectFromFilterField(String dropdownValue) {
        selectFromDropdown(cssFilterField, dropdownValue);
    }

    public void find() {
        cssFindButton.click();
    }

    public String getSearchResultsNumber() {
        return cssSearchResultsNumber.getText().substring(0,1);
    }

    public String getNumberOfItemsInResults() {
        return String.valueOf(cssListOfArticles.size());

    }



}
