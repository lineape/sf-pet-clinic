package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.PetType;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;

public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
  private Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  @Override
  public PetType save(PetType o) {
    if (o.isNew()) {
      o.setId(generateId());
    }

    return save(o.getId(), o);
  }

  @Override
  public PetType findByName(String name) {
    PetType match = null;

    for (PetType o : map.values()) {
      if (o.getName().equals(name)) {
        match = o;
        break;
      }
    }

    return match;
  }
}
