package ca.elikellendonk.sfpetclinic.services.jpa;

import ca.elikellendonk.sfpetclinic.model.PetType;
import ca.elikellendonk.sfpetclinic.repositories.PetTypeRepository;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;

public class PetTypeServiceJpa implements PetTypeService {
  private final PetTypeRepository types;

  public PetTypeServiceJpa(PetTypeRepository types) {
    this.types = types;
  }

  @Override
  public PetType findById(Long id) {
    return types.findById(id).orElse(null);
  }

  @Override
  public PetType save(PetType o) {
    return types.save(o);
  }

  @Override
  public Iterable<PetType> findAll() {
    return types.findAll();
  }

  @Override
  public void delete(PetType o) {
    types.delete(o);
  }

  @Override
  public void deleteById(Long id) {
    types.deleteById(id);
  }

  @Override
  public long count() {
    return types.count();
  }
}
