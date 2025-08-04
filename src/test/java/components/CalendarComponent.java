package components;

import static com.codeborne.selenide.Selenide.$;

import java.util.Calendar;
import java.util.Date;

public class CalendarComponent {

  private String elementSelector,
      monthElementSelector = ".react-datepicker__month-select",
      yearElementSelector = ".react-datepicker__year-select";

  public CalendarComponent(String elementSelector) {
    this.elementSelector = elementSelector;
  }

  public void setDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    setDate(calendar);
  }

  public void setDate(Calendar calendar) {
    $(elementSelector).click();
    $(yearElementSelector).selectOptionByValue(String.valueOf(calendar.get(Calendar.YEAR)));
    $(monthElementSelector).selectOptionByValue(String.valueOf(calendar.get(Calendar.MONTH)));
    $(getDayElementSelector(calendar.get(Calendar.DAY_OF_MONTH))).click();
  }

  private String getDayElementSelector(int day) {
    return String.format(".react-datepicker__day--0%02d:not(.react-datepicker__day--outside-month)",
        day);
  }
}
