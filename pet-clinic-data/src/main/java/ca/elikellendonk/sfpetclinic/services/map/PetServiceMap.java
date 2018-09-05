package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import lombok.NonNull;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
  private PetTypeService petTypeService;

  public PetServiceMap(PetTypeService petTypeService) {
    this.petTypeService = petTypeService;
  }

  private Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  @Override
  public Pet save(@NonNull Pet pet) {
    if (pet.isNew()) {
      pet.setId(generateId());
    }

    if (pet.getPetType() != null && pet.getPetType().isNew()) {
      petTypeService.save(pet.getPetType());
    }

    return save(pet.getId(), pet);
  }
}
