package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.services.CrudService;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapService<T, Id> implements CrudService<T, Id> {
  protected Map<Id, T> map = new HashMap<>();

  public T findById(Id id) {
    return map.get(id);
  }

  public Iterable<T> findAll() {
    return map.values();
  }

  public void delete(T o) {
    map.entrySet().removeIf(entry -> entry.getValue().equals(o));
  }

  public void deleteById(Id id) {
    map.remove(id);
  }

  protected T save(Id id, T o) {
    map.put(id, o);

    return o;
  }
}
