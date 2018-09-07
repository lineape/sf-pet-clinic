package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(
    callSuper = true,
    exclude = {"vets"})
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {
  @NonNull
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToMany(mappedBy = "specialties")
  private Set<Vet> vets = new HashSet<>();

  public Specialty(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
