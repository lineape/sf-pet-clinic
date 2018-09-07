package ca.elikellendonk.sfpetclinic.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
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
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  @ManyToOne
  @JoinColumn(name = "vet_id")
  private Vet vet;

  @Builder
  public Visit(String description, LocalDate date, Pet pet, Vet vet) {
    this(description);
    this.date = date == null ? this.date : date;
    this.pet = pet;
    this.vet = vet;
  }

  public Visit(String description) {
    this.description = description;
    date = LocalDate.now();
  }
}
