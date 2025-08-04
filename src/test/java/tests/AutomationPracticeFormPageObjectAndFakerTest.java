package tests;

import base.TestBase;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static data.TestValue.*;

public class AutomationPracticeFormPageObjectAndFakerTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  void successfulRegistrationTestWithFakerData() {
    registrationPage.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setEmail(userEmail)
        .setGender(userGender)
        .setPhoneNumber(userPhoneNumber)
        .setBirthDate(userBirthDate)
        .setSubjects(userSubjects)
        .setHobbies(userHobby)
        .uploadPicture(userPictureFilePath)
        .setCurrentAddress(userAddress)
        .setState(userState)
        .setCity(userCity)
        .submit();

    // Checks
    registrationPage.checkResult("Student Name", firstName + " " + lastName)
        .checkResult("Student Email", userEmail)
        .checkResult("Gender", userGender)
        .checkResult("Mobile", userPhoneNumber)
        .checkResult("Date of Birth", userBirthDateFormatted)
        .checkResult("Subjects", userSubjects)
        .checkResult("Hobbies", userHobby)
        .checkResult("Picture", userPictureFileName)
        .checkResult("Address", userAddress)
        .checkResult("State and City", userState + " " + userCity);
  }
}
