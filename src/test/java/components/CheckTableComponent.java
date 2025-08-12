package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckTableComponent {

  SelenideElement table = $(".table-responsive");

  public void checkTableContainsRow(String label, String value) {
    table.$(byText(label)).parent().shouldHave(text(value));
  }

  public void checkTableIsNotVisible() {
    table.shouldNotBe(visible);
  }

}
