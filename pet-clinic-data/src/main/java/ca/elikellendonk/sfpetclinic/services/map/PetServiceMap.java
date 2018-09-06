package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;

public class PetServiceMap extends AbstractMapService<Pet> implements PetService {
  private PetTypeService petTypeService;

  public PetServiceMap(PetTypeService petTypeService) {
    this.petTypeService = petTypeService;
  }

  @Override
  public Pet findByName(String name) {
    for (Pet pet : map.values()) {
      if (pet.getName().equals(name)) {
        return pet;
      }
    }

    return null;
  }

  @Override
  public Pet save(Pet pet) {
    if (pet == null) {
      return null;
    }
    if (pet.isNew()) {
      pet.setId(generateId());
    }

    if (pet.getPetType() != null && pet.getPetType().isNew()) {
      petTypeService.save(pet.getPetType());
    }

    return save(pet.getId(), pet);
  }
}
