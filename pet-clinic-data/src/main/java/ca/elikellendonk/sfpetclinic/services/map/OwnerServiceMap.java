package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import lombok.NonNull;

public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {
  private PetService petService;

  public OwnerServiceMap(PetService petService) {
    this.petService = petService;
  }

  @Override
  public Owner findByLastName(String lastName) {
    for (Owner o : map.values()) {
      if (o.getLastName().equals(lastName)) {
        return o;
      }
    }

    return null;
  }

  @Override
  public Owner save(@NonNull Owner owner) {
    if (owner == null) {
      return null;
    }
    if (owner.isNew()) {
      owner.setId(generateId());
    }

    for (Pet pet : owner.getPets()) {
      if (pet.isNew()) {
        petService.save(pet);
      }
    }

    return save(owner.getId(), owner);
  }
}
