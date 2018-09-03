package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
  private Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  @Override
  public Vet save(Vet vet) {
    if (vet.isNew()) {
      vet.setId(generateId());
    }

    return save(vet.getId(), vet);
  }
}
