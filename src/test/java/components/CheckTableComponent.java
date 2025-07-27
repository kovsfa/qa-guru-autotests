package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckTableComponent {

  SelenideElement table = $(".table-responsive");

  public void checkTable(String key, String value) {
    $(table).$(byText(key)).parent().shouldHave(text(value));
  }

}
