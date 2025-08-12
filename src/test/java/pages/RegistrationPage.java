package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.CheckTableComponent;
import java.util.Date;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

  private final SelenideElement userForm = $("#userForm"),
      firstNameInput = $("#firstName"),
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

  private final CalendarComponent dateOfBirthComponent = new CalendarComponent("#dateOfBirthInput");
  private final CheckTableComponent checkTableComponent = new CheckTableComponent();

  public RegistrationPage openPage() {
    open("/automation-practice-form");

    return this.closeAd();
  }

  public RegistrationPage closeAd() {
    executeJavaScript("$('footer').remove();");
    executeJavaScript("$('#fixedban').remove();");

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

  public RegistrationPage setPhoneNumber(String value) {
    userNumber.setValue(value);

    return this;
  }

  public RegistrationPage setBirthDate(Date date) {
    calendarInput.click();
    dateOfBirthComponent.setDate(date);

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
    submitButton.scrollIntoView(true).click();
  }

  public RegistrationPage checkResult(String key, String value) {
    checkTableComponent.checkTable(key, value);

    return this;
  }

  public void checkFormWasValidatedButTableIsNotVisible() {
    userForm.shouldHave(cssClass("was-validated"));
    checkTableComponent.checkTableIsNotVisible();
  }

}
