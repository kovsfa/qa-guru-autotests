package data;

import java.util.Date;

public class TestValue {

  public static String firstName = TestDataGenerator.getFirstName();
  public static String lastName = TestDataGenerator.getLastName();
  public static String userEmail = TestDataGenerator.getEmail();
  public static String userAddress = TestDataGenerator.getAddress();
  public static String userGender = TestDataGenerator.getGender();
  public static String userPhoneNumber = TestDataGenerator.getPhoneNumber();
  public static Date userBirthDate = TestDataGenerator.getBirthDate();
  public static String userBirthDateFormatted = TestDataGenerator.formatDate(userBirthDate);
  public static String userSubjects = TestDataGenerator.getSubject();
  public static String userHobby = TestDataGenerator.getHobby();
  public static String userPictureFilePath = TestDataGenerator.getFilePath();
  public static String userPictureFileName = TestDataGenerator.getFileName(userPictureFilePath);
  public static String userState = TestDataGenerator.getState();
  public static String userCity = TestDataGenerator.getCity(userState);
}
