package ca.elikellendonk.sfpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(
    callSuper = true,
    exclude = {"pets"})
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {
  @NonNull
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "petType")
  private Set<Pet> pets = new HashSet<>();
}
