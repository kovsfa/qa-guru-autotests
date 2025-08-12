package tests;

import base.TestBase;
import data.UserTestData;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

public class AutomationPracticeFormPageObjectAndFakerTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();
  UserTestData u;

  @BeforeEach
  void setupData() {
    u = UserTestData.getInstance();
  }

  @Test
  void successfulRegistrationTestWithFakerData() {
    registrationPage.openPage()
        .setFirstName(u.firstName)
        .setLastName(u.lastName)
        .setEmail(u.email)
        .setGender(u.gender)
        .setPhoneNumber(u.phoneNumber)
        .setBirthDate(u.dateOfBirth)
        .setSubjects(u.subject)
        .setHobbies(u.hobby)
        .uploadPicture(u.pictureFilePath)
        .setCurrentAddress(u.address)
        .setState(u.state)
        .setCity(u.city)
        .submit();

    // Checks
    registrationPage.checkResult("Student Name", u.firstName + " " + u.lastName)
        .checkResult("Student Email", u.email)
        .checkResult("Gender", u.gender)
        .checkResult("Mobile", u.phoneNumber)
        .checkResult("Date of Birth", u.dateOfBirthFormatted)
        .checkResult("Subjects", u.subject)
        .checkResult("Hobbies", u.hobby)
        .checkResult("Picture", u.pictureFileName)
        .checkResult("Address", u.address)
        .checkResult("State and City", u.state + " " + u.city);
  }

  @Test
  void minimalSuccessfulDataTest() {
    registrationPage.openPage()
        .setFirstName(u.firstName)
        .setLastName(u.lastName)
        .setGender(u.gender)
        .setPhoneNumber(u.phoneNumber)
        .submit();

    // Checks
    registrationPage.checkResult("Student Name", u.firstName + " " + u.lastName)
        .checkResult("Gender", u.gender)
        .checkResult("Mobile", u.phoneNumber);
  }

  @Test
  void emptyNameNegativeTest() {
    registrationPage.openPage()
        .setLastName(u.lastName)
        .setGender(u.gender)
        .setPhoneNumber(u.phoneNumber)
        .submit();

    // Checks
    registrationPage.checkFormWasValidatedButTableIsNotVisible();
  }
}
