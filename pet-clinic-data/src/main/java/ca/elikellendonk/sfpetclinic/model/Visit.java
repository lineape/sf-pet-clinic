package ca.elikellendonk.sfpetclinic.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(
    callSuper = true,
    exclude = {"pet", "vet"})
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
  @NonNull
  @Column(name = "description")
  private String description;

  @NonNull
  @Column(name = "date")
  private LocalDate date = LocalDate.now();

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  @ManyToOne
  @JoinColumn(name = "vet_id")
  private Vet vet;
}
