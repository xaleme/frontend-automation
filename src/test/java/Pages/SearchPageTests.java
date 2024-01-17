package Pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.Config.WebDriverSetup;
import org.example.Pages.SearchPage;
import org.junit.jupiter.api.*;

@Tag("All")
public class SearchPageTests extends SearchPage {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        WebDriverSetup.openPage("/");
    }

    @BeforeEach
    public void acceptCookies() {
        allowCookies();
        searchFor("IFRS");
    }

    @Test
    public void testFilterField() {
        selectFromFilterField("ContentGroup");
        find();
        Assertions.assertEquals(getNumberOfItemsInResults(), getSearchResultsNumber());

    }
}
