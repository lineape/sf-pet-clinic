package ca.elikellendonk.sfpetclinic.model;

import javax.persistence.Entity;

@Entity
public class PetType {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
