package ca.elikellendonk.sfpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(
    callSuper = true,
    exclude = {"owner", "petType", "visits"})
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
  @NonNull
  @Column(name = "name")
  private String name;

  @NonNull
  @Column(name = "birth_date")
  private LocalDate birthDate;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Visit> visits = new HashSet<>();

  public void setPetType(PetType petType) {
    this.petType = petType;
    petType.getPets().add(this);
  }
}
