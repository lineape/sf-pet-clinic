package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
  private Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  @Override
  public Pet save(Pet pet) {
    if (pet.isNew()) {
      pet.setId(generateId());
    }

    return save(pet.getId(), pet);
  }
}
