package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageObjectTest extends TestBase {

  TextBoxPage textBoxPage = new TextBoxPage();

  @Test
  void textBox() {
    textBoxPage.openPage()
        .setUserName("Test1")
        .setUserEmail("test1@gmail.com")
        .setCurrentAddress("Test1 Current Address")
        .setPermanentAddress("Test1 Permanent Address")
        .submit();

    textBoxPage.checkResult("Name:", "Test1")
        .checkResult("Email:", "test1@gmail.com")
        .checkResult("Current Address :", "Test1 Current Address")
        .checkResult("Permananet Address :", "Test1 Permanent Address");
  }

}
