package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToMany(mappedBy = "specialties")
  private Set<Vet> vets = new HashSet<>();

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
