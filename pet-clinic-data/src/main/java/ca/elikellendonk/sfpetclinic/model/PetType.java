package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "petType")
  private Set<Pet> pets = new HashSet<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Pet> getPets() {
    return pets;
  }

  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }

  public void addPet(Pet pet) {
    pets.add(pet);
    pet.setPetType(this);
  }
}
