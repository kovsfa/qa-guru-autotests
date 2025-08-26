package model;

import java.util.List;

public class DomesticAnimals {
  private String name;
  private boolean vaccinated;
  private int age;
  private List<String> diseases;
  private AnimalOwner owner;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public boolean isVaccinated() { return vaccinated; }
  public void setVaccinated(boolean vaccinated) { this.vaccinated = vaccinated; }

  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }

  public List<String> getDiseases() { return diseases; }
  public void setDiseases(List<String> diseases) { this.diseases = diseases; }

  public AnimalOwner getOwner() { return owner; }
  public void setOwner(AnimalOwner owner) { this.owner = owner; }


}
