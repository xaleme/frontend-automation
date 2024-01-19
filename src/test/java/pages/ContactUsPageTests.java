package pages;

import org.example.pages.ContactUsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.example.config.AllureSetup.enableAllureListener;
import static org.example.config.WebDriverSetup.openPage;
import static org.example.model.ContactUsFormFields.COUNTRY;
import static org.example.model.ContactUsFormFields.FIRST_NAME;

@Tag("All")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class ContactUsPageTests {

    ContactUsPage contactUsPage = new ContactUsPage();


    @BeforeAll
    public void setup() {
        enableAllureListener();
        openPage("/en-gb/contact/");
        contactUsPage.allowCookies();
    }

    @Test
     void testContactUsPageTitle() {
        Assertions.assertEquals("Contact us", contactUsPage.getPageTitleText());
    }

    @Test
     void testFirstNameField() {
        contactUsPage.addDataToFormFields(FIRST_NAME, "Alexandru");
        contactUsPage.submitForm();
        Assertions.assertTrue(contactUsPage.hasTextInFormField(FIRST_NAME));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Aruba", "Jamaica", "ooh I wanna take ya to", "Bermuda", "Bahamas"})
     void testCountryField(String countryName) {
        contactUsPage.addDataToFormFields(countryName);
        Assertions.assertTrue(contactUsPage.hasTextInFormField(COUNTRY));
    }


    @Test
     void testFirstNameErrorMessage() {
        Assertions.assertEquals("Please complete this required field.", contactUsPage.getFieldErrorMessage(FIRST_NAME));
    }
}
