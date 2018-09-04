package ca.elikellendonk.sfpetclinic.services;

import ca.elikellendonk.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
  public Owner findByLastName(String lastName);
}
