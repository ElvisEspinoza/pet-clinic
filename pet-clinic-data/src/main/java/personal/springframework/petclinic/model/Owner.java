package personal.springframework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

  public Owner(){}

  public Owner(Long id, String firstName, String lastName, String address, String city,
      String telephone, Set<Pet> pets) {
    super(id, firstName, lastName);
    this.address = address;
    this.city = city;
    this.telephone = telephone;

    if(pets != null) {
      this.pets = pets;
    }
  }

  private String address;
  private String city;
  private String telephone;

  private Set<Pet> pets = new HashSet<>();

  public Pet getPet(String name) {
    return getPet(name, false);
  }

  public Pet getPet(String name, boolean ignoreNew) {
    name = name.toLowerCase();
    for (Pet pet : pets) {
      if (!ignoreNew || !pet.isNew()) {
        String compName = pet.getName();
        compName = compName.toLowerCase();
        if (compName.equals(name)) {
          return pet;
        }
      }
    }
    return null;
  }

}
