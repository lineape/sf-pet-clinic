package ca.elikellendonk.sfpetclinic.services;

import java.util.List;

public interface CrudService<T, Id> {
  public T findById(Id id);

  public T save(T o);

  public List<T> findAll();

  public void delete(T o);

  public void deleteById(Id id);
}
