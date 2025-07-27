package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.CheckTableComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

  private final SelenideElement firstNameInput = $("#firstName"),
      lastNameInput = $("#lastName"),
      userEmailInput = $("#userEmail"),
      genderWrapper = $("#genterWrapper"),
      userNumber = $("#userNumber"),
      calendarInput = $("#dateOfBirthInput"),
      subjectInput = $("#subjectsInput"),
      hobbyInput = $("#hobbiesWrapper"),
      pictureInput = $("#uploadPicture"),
      currentAddressInput = $("#currentAddress"),
      stateInput = $("#state"),
      cityInput = $("#city"),
      submitButton = $("#submit");

  CalendarComponent calendarComponent = new CalendarComponent();
  CheckTableComponent checkTableComponent = new CheckTableComponent();

  public RegistrationPage openPage() {
    open("/automation-practice-form");

    return this;
  }

  public RegistrationPage setFirstName(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setLastName(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setEmail(String value) {
    userEmailInput.setValue(value);

    return this;
  }

  public RegistrationPage setGender(String value) {
    genderWrapper.$(byText(value)).click();

    return this;
  }

  public RegistrationPage setUserNumber(String value) {
    userNumber.setValue(value);

    return this;
  }

  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(day, month, year);

    return this;
  }

  public RegistrationPage setSubjects(String value) {
    subjectInput.setValue(value).pressEnter();

    return this;
  }

  public RegistrationPage setHobbies(String value) {
    hobbyInput.$(byText(value)).click();

    return this;
  }

  public RegistrationPage uploadPicture(String filePath) {
    pictureInput.uploadFromClasspath(filePath);

    return this;
  }

  public RegistrationPage setCurrentAddress(String value) {
    currentAddressInput.setValue(value);

    return this;
  }

  public RegistrationPage setState(String value) {
    stateInput.click();
    $$(byText(value)).first().click();

    return this;
  }

  public RegistrationPage setCity(String value) {
    cityInput.click();
    $$(byText(value)).first().click();

    return this;
  }

  public void submit() {
    submitButton.click();
  }

  public RegistrationPage checkResult(String key, String value) {
    checkTableComponent.checkTable(key, value);

    return this;
  }

}
