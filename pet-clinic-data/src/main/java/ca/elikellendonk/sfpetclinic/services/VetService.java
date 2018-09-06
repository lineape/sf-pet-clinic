package ca.elikellendonk.sfpetclinic.services;

import ca.elikellendonk.sfpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
  Vet findByFirstName(String firstName);

  Vet findByLastName(String lastName);

  Vet findByFirstNameAndLastName(String firstName, String lastName);
}
