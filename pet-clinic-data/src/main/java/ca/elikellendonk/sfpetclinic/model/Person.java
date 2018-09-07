package ca.elikellendonk.sfpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person extends BaseEntity {
  @NonNull
  @Column(name = "first_name")
  private String firstName;

  @NonNull
  @Column(name = "last_name")
  private String lastName;

  public Person() {}

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
