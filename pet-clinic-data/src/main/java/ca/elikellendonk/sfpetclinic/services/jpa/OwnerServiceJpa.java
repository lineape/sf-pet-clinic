package ca.elikellendonk.sfpetclinic.services.jpa;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.repositories.OwnerRepository;
import ca.elikellendonk.sfpetclinic.services.OwnerService;

public class OwnerServiceJpa implements OwnerService {
  private final OwnerRepository owners;

  public OwnerServiceJpa(OwnerRepository owners) {
    this.owners = owners;
  }

  @Override
  public Owner findByLastName(String lastName) {
    return owners.findFirstByLastName(lastName);
  }

  @Override
  public Owner findById(Long id) {
    return owners.findById(id).orElse(null);
  }

  @Override
  public Owner save(Owner o) {
    return owners.save(o);
  }

  @Override
  public Iterable<Owner> findAll() {
    return owners.findAll();
  }

  @Override
  public void delete(Owner o) {
    owners.delete(o);
  }

  @Override
  public void deleteById(Long id) {
    owners.deleteById(id);
  }

  @Override
  public long count() {
    return owners.count();
  }
}
