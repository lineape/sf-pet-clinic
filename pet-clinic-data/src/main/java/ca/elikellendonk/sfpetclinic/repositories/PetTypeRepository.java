package ca.elikellendonk.sfpetclinic.repositories;

import ca.elikellendonk.sfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {}
