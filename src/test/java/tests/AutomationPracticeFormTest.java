package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest extends TestBase {
    @Test
    void autoPracticeFormTest() {
        open("/automation-practice-form");

        // Name
        $("#firstName").setValue("Sofia");
        $("#lastName").setValue("Kovaleva");

        // Email
        $("#userEmail").setValue("kov.sfa@gmail.com");

        // Gender
        $("#genterWrapper").$(byText("Female")).click();

        // Phone number
        $("#userNumber").setValue("7058745235");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $(".react-datepicker__day--020").click();

        // Subjects
        $("#subjectsInput").setValue("English").pressEnter();

        // Hobby
        $("#hobbiesWrapper").$(byText("Sports")).click();

        // Upload picture
        $("#uploadPicture").uploadFromClasspath("assets/cat.jpg");

        // AddressComponent
        $("#currentAddress").setValue("Baribaeva street");
        $("#state").click();
        $$(byText("Uttar Pradesh")).first().click();
        $("#city").click();
        $$(byText("Agra")).first().click();

        // Submit
        $("#submit").click();

        // Checks
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Sofia Kovaleva"));
        $(".table-responsive").shouldHave(text("kov.sfa@gmail.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("7058745235"));
        $(".table-responsive").shouldHave(text("20 November,1996"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("cat.jpg"));
        $(".table-responsive").shouldHave(text("Baribaeva street"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
    }

}
