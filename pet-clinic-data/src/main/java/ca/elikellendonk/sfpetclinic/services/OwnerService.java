package ca.elikellendonk.sfpetclinic.services;

import ca.elikellendonk.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
  Owner findByLastName(String lastName);
}
