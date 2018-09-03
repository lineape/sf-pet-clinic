package ca.elikellendonk.sfpetclinic.services;

import ca.elikellendonk.sfpetclinic.model.Pet;
import java.util.Set;

public interface PetService {
  Pet findById(Long id);

  Pet save(Pet pet);

  Set<Pet> findAll();
}
