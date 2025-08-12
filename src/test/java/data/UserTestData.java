package data;

import java.util.Date;

public class UserTestData {

  public final String firstName, lastName, email, address, gender, phoneNumber;
  public final Date dateOfBirth;
  public final String dateOfBirthFormatted, subject, hobby, pictureFilePath, pictureFileName, state, city;

  private UserTestData(String firstName, String lastName, String email, String address, String gender,
      String phoneNumber, Date dateOfBirth, String dateOfBirthFormatted, String subject,
      String hobby, String pictureFilePath, String pictureFileName, String state, String city) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.dateOfBirthFormatted = dateOfBirthFormatted;
    this.subject = subject;
    this.hobby = hobby;
    this.pictureFilePath = pictureFilePath;
    this.pictureFileName = pictureFileName;
    this.state = state;
    this.city = city;
  }

  public static UserTestData getInstance() {
    Date dateOfBirth = TestDataGenerator.getDateOfBirth();
    String filePath = TestDataGenerator.getFilePath();
    String state = TestDataGenerator.getState();
    return new UserTestData(TestDataGenerator.getFirstName(), TestDataGenerator.getLastName(),
        TestDataGenerator.getEmail(), TestDataGenerator.getAddress(), TestDataGenerator.getGender(),
        TestDataGenerator.getPhoneNumber(), dateOfBirth, TestDataGenerator.formatDate(dateOfBirth),
        TestDataGenerator.getSubject(), TestDataGenerator.getHobby(), filePath,
        TestDataGenerator.getFileName(filePath), state, TestDataGenerator.getCity(state));
  }
}
