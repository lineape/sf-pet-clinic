package ca.elikellendonk.sfpetclinic.repositories;

import ca.elikellendonk.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {}
