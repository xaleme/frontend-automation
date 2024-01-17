package Pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.Config.WebDriverSetup;
import org.example.Pages.ContactUsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.example.Config.WebDriverSetup.closeBrowser;
import static org.example.Enums.ContactUsFormFields.FIRST_NAME;

@Tag("All")
public class ContactUsPageTests extends ContactUsPage {


    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        WebDriverSetup.openPage("/en-gb/contact/");

    }

    @BeforeEach
    public void acceptCookies() {
        allowCookies();
    }


    @Test
    public void testContactUsPageTitle() {
        Assertions.assertEquals(getPageTitleText(), "Contact us");
    }

    @Test
    public void testFirstNameField() {
        addDataToFormFields(FIRST_NAME, "Alexandru");
        submitForm();
        Assertions.assertTrue(hasTextInFormField(FIRST_NAME));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Aruba", "Jamaica", "ooh I wanna take ya to", "Bermuda", "Bahamas"})
    public void testCountryField(String countryName) {
        addDataToFormFields(countryName);
    }


    @Test
    public void testFirstNameErrorMessage() {
        Assertions.assertEquals("Please complete this required field.", getFieldErrorMessage(FIRST_NAME));
    }

    @AfterAll
    public static void tearDown() {
        closeBrowser();
    }

}
