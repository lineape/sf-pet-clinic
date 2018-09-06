package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.BaseEntity;
import ca.elikellendonk.sfpetclinic.services.CrudService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T extends BaseEntity> implements CrudService<T, Long> {
  protected Long generateId() {
    Long lastId = 0L;

    for (Long id : map.keySet()) {
      lastId = id > lastId ? id : lastId;
    }

    return lastId + 1;
  }

  protected Map<Long, T> map = new HashMap<>();

  public T findById(Long id) {
    return map.get(id);
  }

  public List<T> findAll() {
    return new ArrayList<>(map.values());
  }

  public void delete(T o) {
    map.entrySet().removeIf(entry -> entry.getValue().equals(o));
  }

  public void deleteById(Long id) {
    map.remove(id);
  }

  public T save(T o) {
    if (o == null) {
      return null;
    }
    if (o.isNew()) {
      o.setId(generateId());
    }

    return save(o.getId(), o);
  }

  @Override
  public long count() {
    return map.size();
  }

  protected T save(Long id, T o) {
    map.put(id, o);

    return o;
  }
}
