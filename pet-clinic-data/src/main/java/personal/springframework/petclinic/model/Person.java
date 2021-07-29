package personal.springframework.petclinic.model;

import javax.persistence.Column;


public class Person extends BaseEntity {

  public Person() {
  }

  public Person(Long id, String firstName, String lastName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

}