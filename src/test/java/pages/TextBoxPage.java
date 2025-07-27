package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

  private SelenideElement userNameInput = $("#userName"),
      userEmailInput = $("#userEmail"),
      currentAddressInput = $("#currentAddress"),
      permamentAddressInput = $("#permanentAddress"),
      submitButton = $("#submit"),
      outputArea = $("#output");

  public TextBoxPage openPage() {
    open("/text-box");

    return this;
  }

  public TextBoxPage setUserName(String value) {
    userNameInput.setValue(value);

    return this;
  }

  public TextBoxPage setUserEmail(String value) {
    userEmailInput.setValue(value);

    return this;
  }

  public TextBoxPage setCurrentAddress(String value) {
    currentAddressInput.setValue(value);

    return this;
  }

  public TextBoxPage setPermanentAddress(String value) {
    permamentAddressInput.setValue(value);

    return this;
  }

  public void submit() {
    submitButton.click();
  }

  public TextBoxPage checkResult(String key, String value) {
    outputArea.$(byText(key)).shouldHave(text(value));

    return this;
  }
}
