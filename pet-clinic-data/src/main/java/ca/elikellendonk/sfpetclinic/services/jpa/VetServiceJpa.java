package ca.elikellendonk.sfpetclinic.services.jpa;

import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.repositories.VetRepository;
import ca.elikellendonk.sfpetclinic.services.VetService;

public class VetServiceJpa implements VetService {
  private final VetRepository vets;

  public VetServiceJpa(VetRepository vets) {
    this.vets = vets;
  }

  @Override
  public Vet findById(Long id) {
    return vets.findById(id).orElse(null);
  }

  @Override
  public Vet save(Vet o) {
    return vets.save(o);
  }

  @Override
  public Iterable<Vet> findAll() {
    return vets.findAll();
  }

  @Override
  public void delete(Vet o) {
    vets.delete(o);
  }

  @Override
  public void deleteById(Long id) {
    vets.deleteById(id);
  }

  @Override
  public long count() {
    return vets.count();
  }

  @Override
  public Vet findByFirstName(String firstName) {
    return vets.findByFirstName(firstName);
  }

  @Override
  public Vet findByLastName(String lastName) {
    return vets.findByLastName(lastName);
  }

  @Override
  public Vet findByFirstNameAndLastName(String firstName, String lastName) {
    return vets.findByFirstNameAndLastName(firstName, lastName);
  }
}
