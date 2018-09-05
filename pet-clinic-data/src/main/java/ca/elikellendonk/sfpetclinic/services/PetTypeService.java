package ca.elikellendonk.sfpetclinic.services;

import ca.elikellendonk.sfpetclinic.model.PetType;

public interface PetTypeService extends CrudService<PetType, Long> {
  public PetType findByName(String name);
}
