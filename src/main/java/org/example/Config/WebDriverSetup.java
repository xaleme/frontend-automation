package org.example.Config;

import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSetup {

    private static final String baseURL = "https://www.lucanet.com";

    public static void openPage(String page){
        WebDriverRunner.setWebDriver(ChromeDriver.builder().build());
        Selenide.open(baseURL+page);
    }

    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}
