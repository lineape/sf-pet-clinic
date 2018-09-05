package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import lombok.NonNull;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
  private PetService petService;

  public OwnerServiceMap(PetService petService) {
    this.petService = petService;
  }

  private Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  @Override
  public Owner findByLastName(String lastName) {
    Owner owner = null;
    for (Owner o : map.values()) {
      if (o.getLastName().equals(lastName)) {
        owner = o;
      }
    }

    return owner;
  }

  @Override
  public Owner save(@NonNull Owner owner) {
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
