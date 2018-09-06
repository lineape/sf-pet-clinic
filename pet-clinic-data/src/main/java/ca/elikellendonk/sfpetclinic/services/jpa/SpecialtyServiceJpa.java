package ca.elikellendonk.sfpetclinic.services.jpa;

import ca.elikellendonk.sfpetclinic.model.Specialty;
import ca.elikellendonk.sfpetclinic.repositories.SpecialtyRepository;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;

public class SpecialtyServiceJpa implements SpecialtyService {
  private final SpecialtyRepository specialties;

  public SpecialtyServiceJpa(SpecialtyRepository specialties) {
    this.specialties = specialties;
  }

  @Override
  public Specialty findById(Long id) {
    return specialties.findById(id).orElse(null);
  }

  @Override
  public Specialty save(Specialty o) {
    return specialties.save(o);
  }

  @Override
  public Iterable<Specialty> findAll() {
    return specialties.findAll();
  }

  @Override
  public void delete(Specialty o) {
    specialties.delete(o);
  }

  @Override
  public void deleteById(Long id) {
    specialties.deleteById(id);
  }

  @Override
  public long count() {
    return specialties.count();
  }
}
