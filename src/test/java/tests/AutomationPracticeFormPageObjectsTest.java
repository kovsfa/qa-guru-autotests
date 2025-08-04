package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormPageObjectsTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  void successfulRegistrationTest() {
    registrationPage.openPage()
        .setFirstName("Sofia")
        .setLastName("Kovaleva")
        .setEmail("kov.sfa@gmail.com")
        .setGender("Female")
        .setDateOfBirth("20", "10", "1996")
        .setPhoneNumber("7058745235")
        .setSubjects("English")
        .setHobbies("Sports")
        .uploadPicture("assets/cat.jpg")
        .setCurrentAddress("Baribaev street")
        .setState("Uttar Pradesh")
        .setCity("Agra")
        .submit();

    // Checks
    registrationPage.checkResult("Student Name", "Sofia Kovaleva")
        .checkResult("Student Email", "kov.sfa@gmail.com")
        .checkResult("Gender", "Female")
        .checkResult("Mobile", "7058745235")
        .checkResult("Date of Birth", "20 November,1996")
        .checkResult("Subjects", "English")
        .checkResult("Hobbies", "Sports")
        .checkResult("Picture", "cat.jpg")
        .checkResult("Address", "Baribaev street")
        .checkResult("State and City", "Uttar Pradesh Agra");
  }

  @Test
  void minimalSuccessfulDataTest() {
    registrationPage.openPage()
        .setFirstName("Sofia")
        .setLastName("Kovaleva")
        .setGender("Female")
        .setPhoneNumber("7058745235")
        .submit();

    // Checks
    registrationPage.checkResult("Student Name", "Sofia Kovaleva")
        .checkResult("Gender", "Female")
        .checkResult("Mobile", "7058745235");
  }

  @Test
  void emptyNameNegativeTest() {
    registrationPage.openPage()
        .setFirstName("")
        .setLastName("Kovaleva")
        .setGender("Female")
        .setPhoneNumber("7058745235")
        .submit();
  }

}
