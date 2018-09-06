package ca.elikellendonk.sfpetclinic.repositories;

import ca.elikellendonk.sfpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
  Vet findByFirstName(String firstName);

  Vet findByLastName(String lastName);

  Vet findByFirstNameAndLastName(String firstName, String lastName);
}
