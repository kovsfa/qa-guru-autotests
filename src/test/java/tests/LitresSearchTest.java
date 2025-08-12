package tests;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LitresSearchTest {

  @BeforeEach
  void setUp() {
    open("https://www.litres.ru/");
  }

  @CsvSource(value = {"Стивен Кинг, Результаты поиска «Стивен Кинг»",
      "Александр Пушкин, Результаты поиска «Александр Пушкин»"})
  @ParameterizedTest(name = "Для поискового запроса {0} должен отображаться искомый текст: {1}")
  void searchResultShouldNotBeEmpty(String searchQuery, String searchResult) {
    $("[name=q]").setValue(searchQuery).pressEnter();
    $("[data-testid=search-title__wrapper]").shouldHave(text(searchResult));
  }

  @ValueSource(strings = {"Стивен Кинг", "Александр Пушкин"})
  @ParameterizedTest(name = "Клик по первому результату в поиске должен вести на книгу искомого автора: {0}")
  void clickFirstSearchResult(String authorName) {
    $("[name=q]").setValue(authorName).pressEnter();
    $("[data-testid=art__wrapper]").click();
    $$("span").findBy(text(authorName));
  }

  @CsvFileSource(resources = "/test_data/searchResultShouldContainAuthorUrl.csv")
  @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должна быть ссылка {1}")
  void searchResultShouldContainExpectedUrl(String searchQuery, String expectedLink) {
    $("[name=q]").setValue(searchQuery).pressEnter();
    ElementsCollection cards = $$("[data-testid=art__wrapper]").filterBy(visible);
    SelenideElement firstCard = cards.first();
    firstCard.$("a[href*='/author/']")
        .shouldHave(href(expectedLink));
  }
}
