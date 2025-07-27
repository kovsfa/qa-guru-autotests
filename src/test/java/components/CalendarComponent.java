package components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

  String dateOfBirth = "#dateOfBirthInput",
      monthOfBirth = ".react-datepicker__month-select",
      yearOfBirth = ".react-datepicker__year-select",
      dayOfBirth = ".react-datepicker__day--0";

  public void setDate(String day, String month, String year) {
    $(dateOfBirth).click();
    $(monthOfBirth).selectOptionByValue(month);
    $(yearOfBirth).selectOptionByValue(year);

    String paddedDay = String.format("%02d", Integer.parseInt(day));
    $(dayOfBirth + paddedDay).click();
  }

}
