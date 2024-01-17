package org.example.Config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class WebDriverSetup {

    private static final String baseURL = "https://www.lucanet.com";

    public  static void openPage(String page) {
        Configuration.browser = "chrome";
        Configuration.headless = true;

        Selenide.open(baseURL + page);

    }

    public static void closeBrowser() {
        Configuration.holdBrowserOpen = false;
    }
}
