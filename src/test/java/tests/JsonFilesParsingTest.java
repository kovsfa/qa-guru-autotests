package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import model.AnimalOwner;
import model.DomesticAnimals;
import org.junit.jupiter.api.Test;

public class JsonFilesParsingTest {

  @Test
  void jsonFilePetParsingTest() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    DomesticAnimals cat = mapper.readValue(
        getClass().getClassLoader()
            .getResourceAsStream("test_data/animalsCard.json"), DomesticAnimals.class);

    assertEquals("Барсик", cat.getName());
    assertTrue(cat.isVaccinated());
    assertEquals(3, cat.getAge());

    List<String> diseases = cat.getDiseases();
    assertNotNull(diseases);
    assertTrue(diseases.contains("ринит"));
    assertTrue(diseases.contains("аллергия"));

    AnimalOwner owner = cat.getOwner();
    assertNotNull(owner);
    assertEquals("Иван Иванов", owner.getFullName());
  }
}
