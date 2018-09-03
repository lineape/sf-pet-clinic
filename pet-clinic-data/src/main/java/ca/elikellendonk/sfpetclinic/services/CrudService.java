package ca.elikellendonk.sfpetclinic.services;

public interface CrudService<T, Id> {
  T findById(Id id);

  T save(T o);

  Iterable<T> findAll();

  void delete(T o);

  void deleteById(Id id);
}
