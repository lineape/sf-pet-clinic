package ca.elikellendonk.sfpetclinic.repositories;

import ca.elikellendonk.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
  Owner findFirstByLastName(String lastName);
}
