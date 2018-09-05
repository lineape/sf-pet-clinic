package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Specialty;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;

public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long>
    implements SpecialtyService {
  private Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  @Override
  public Specialty save(Specialty o) {
    if (o.isNew()) {
      o.setId(generateId());
    }

    return super.save(o.getId(), o);
  }
}
