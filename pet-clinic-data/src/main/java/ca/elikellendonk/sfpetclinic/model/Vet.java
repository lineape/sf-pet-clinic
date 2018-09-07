package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(
    callSuper = true,
    exclude = {"specialties", "visits"})
@Entity
@Table(name = "vets")
public class Vet extends Person {
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "vet_specialties",
      joinColumns = @JoinColumn(name = "vet_id"),
      inverseJoinColumns = @JoinColumn(name = "specialty_id"))
  private Set<Specialty> specialties = new HashSet<>();

  @OneToMany(mappedBy = "vet")
  private Set<Visit> visits = new HashSet<>();

  public Vet(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public void addSpecialty(Specialty specialty) {
    specialties.add(specialty);
    specialty.getVets().add(this);
  }
}
