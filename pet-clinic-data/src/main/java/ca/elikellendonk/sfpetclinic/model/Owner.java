package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(
    callSuper = true,
    exclude = {"pets"})
@Entity
@Table(name = "owners")
public class Owner extends Person {
  @NonNull
  @Column(name = "address")
  private String address;

  @NonNull
  @Column(name = "city")
  private String city;

  @NonNull
  @Column(name = "telephone")
  private String telephone;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private Set<Pet> pets = new HashSet<>();

  @Builder
  public Owner(
      String firstName,
      String lastName,
      String address,
      String city,
      String telephone,
      Set<Pet> pets) {
    this(firstName, lastName, address, city, telephone);
    this.pets = pets != null ? pets : new HashSet<>();
  }

  public Owner(String firstName, String lastName, String address, String city, String telephone) {
    super(firstName, lastName);
    this.address = address;
    this.city = city;
    this.telephone = telephone;
  }

  public void addPet(Pet pet) {
    pets.add(pet);
    pet.setOwner(this);
  }
}
