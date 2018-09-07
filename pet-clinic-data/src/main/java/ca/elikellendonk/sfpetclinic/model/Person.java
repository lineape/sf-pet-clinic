package ca.elikellendonk.sfpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseEntity {
  @NonNull
  @Column(name = "first_name")
  private String firstName;

  @NonNull
  @Column(name = "last_name")
  private String lastName;
}
