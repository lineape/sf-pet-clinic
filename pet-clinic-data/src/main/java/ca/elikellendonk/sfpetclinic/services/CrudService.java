package ca.elikellendonk.sfpetclinic.services;

public interface CrudService<T, Id> {
  public T findById(Id id);

  public T save(T o);

  public Iterable<T> findAll();

  public void delete(T o);

  public void deleteById(Id id);

  public long count();
}
