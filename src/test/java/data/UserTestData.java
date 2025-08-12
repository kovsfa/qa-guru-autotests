package data;

import java.util.Date;

public class UserTestData {

  public final String firstName = TestDataGenerator.getFirstName();
  public final String lastName = TestDataGenerator.getLastName();
  public final String email = TestDataGenerator.getEmail();
  public final String address = TestDataGenerator.getAddress();
  public final String gender = TestDataGenerator.getGender();
  public final String phoneNumber = TestDataGenerator.getPhoneNumber();
  public final Date dateOfBirth = TestDataGenerator.getDateOfBirth();
  public final String dateOfBirthFormatted = TestDataGenerator.formatDate(dateOfBirth);
  public final String subject = TestDataGenerator.getSubject();
  public final String hobby = TestDataGenerator.getHobby();
  public final String pictureFilePath = TestDataGenerator.getFilePath();
  public final String pictureFileName = TestDataGenerator.getFileName(pictureFilePath);
  public final String state = TestDataGenerator.getState();
  public final String city = TestDataGenerator.getCity(state);

  private UserTestData() {}

  public static UserTestData getInstance() {
    return new UserTestData();
  }
}
