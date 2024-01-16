package Pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.Config.WebDriverSetup;
import org.example.Enums.ContactUsFormFields;
import org.example.Pages.ContactUsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static org.example.Config.WebDriverSetup.closeBrowser;
import static org.example.Enums.ContactUsFormFields.FIRST_NAME;

@Tag("All")
public class ContactUsPageTests extends ContactUsPage {


    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide().screenshots(true).savePageSource(true));
        WebDriverSetup.openPage("/en-gb/contact/");

    }

    @BeforeEach
    public void acceptCookies() {
        allowCookies();
    }


    @Test
    public void testContactUsPageTitle() {
        pageTitle.shouldBe(visible);
        Assertions.assertEquals(pageTitle.getText(), "Contact us");
    }

    @Test
    public void testFirstNameField() {
        addDataToFormFields(FIRST_NAME, "Alexandru");
        cssSubmitForm.pressEnter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Aruba", "Jamaica", "ooh I wanna take ya to","Bermuda", "Bahamas"})
    public void testCountryField(String countryName) {
        addDataToFormFields(countryName);
    }

    @AfterAll
    public static void tearDown() {
        closeBrowser();
    }

}
