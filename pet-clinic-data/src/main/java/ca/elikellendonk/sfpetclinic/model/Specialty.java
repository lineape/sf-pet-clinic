package ca.elikellendonk.sfpetclinic.model;

import java.util.Set;

public class Specialty extends BaseEntity {
  private String name;
  private String description;
  private Set<Vet> vets;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Vet> getVets() {
    return vets;
  }

  public void setVets(Set<Vet> vets) {
    this.vets = vets;
  }
}
