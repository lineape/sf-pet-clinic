package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {
  @ManyToMany(mappedBy = "vets")
  private Set<Specialty> specialties = new HashSet<>();

  @OneToMany(mappedBy = "vet")
  private Set<Visit> visits = new HashSet<>();

  public Set<Specialty> getSpecialties() {
    return specialties;
  }

  public void setSpecialties(Set<Specialty> specialties) {
    this.specialties = specialties;
  }

  public Set<Visit> getVisits() {
    return visits;
  }

  public void setVisits(Set<Visit> visits) {
    this.visits = visits;
  }
}
