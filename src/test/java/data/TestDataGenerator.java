package data;

import com.github.javafaker.Faker;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class TestDataGenerator {

  private static final Locale locale = new Locale("en");
  private static final Faker faker = new Faker(locale);
  private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM,yyyy",
      locale);
  private static final Random random = new Random();

  private static final String[] subjects = new String[]{"Hindi", "English", "Maths", "Physics",
      "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts",
      "Social Studies", "History", "Civics"};
  private static final String[] hobbies = new String[]{"Sports", "Reading", "Music"};
  private static final String[] states = new String[]{"NCR", "Uttar Pradesh", "Haryana",
      "Rajasthan"};
  private static final Map<String, String[]> citiesByState = Map.ofEntries(
      Map.entry("NCR", new String[]{"Delhi", "Gurgaon", "Noida"}),
      Map.entry("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"}),
      Map.entry("Haryana", new String[]{"Karnal", "Panipat"}),
      Map.entry("Rajasthan", new String[]{"Jaipur", "Jaiselmer"}));
  private static final String[] assetFiles = new String[]{"assets/cat.jpg", "assets/dog.jpeg",
      "assets/parrot.jpg", "assets/turtle.jpg"};


  public static String getFirstName() {
    return faker.name().firstName();
  }

  public static String getLastName() {
    return faker.name().lastName();
  }

  public static String getEmail() {
    return faker.internet().emailAddress();
  }

  public static String getAddress() {
    return faker.address().streetAddress();
  }

  public static String getGender() {
    return faker.demographic().sex();
  }

  public static String getPhoneNumber() {
    return faker.phoneNumber().subscriberNumber(10);
  }

  public static Date getBirthDate() {
    return faker.date().birthday();
  }

  public static String formatDate(Date date) {
    return dateFormatter.format(date);
  }

  public static String getSubject() {
    return faker.options().option(subjects);
  }

  public static String getHobby() {
    return faker.options().option(hobbies);
  }

  public static String getFilePath() {
    return faker.options().option(assetFiles);
  }

  public static String getFileName(String filePath) {
    return Paths.get(filePath).getFileName().toString();
  }

  public static String getState() {
    return faker.options().option(states);
  }

  public static String getCity(String state) {
    return faker.options().option(citiesByState.get(state));
  }
}

