package org.example.config;

import com.codeborne.selenide.Selenide;

public class WebDriverSetup {

    public static void openPage(String page) {
        Selenide.open(page);
    }

}
