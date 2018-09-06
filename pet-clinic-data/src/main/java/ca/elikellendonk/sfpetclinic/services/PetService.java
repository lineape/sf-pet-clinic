package ca.elikellendonk.sfpetclinic.services;

import ca.elikellendonk.sfpetclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long> {
  Pet findByName(String name);
}
