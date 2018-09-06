package ca.elikellendonk.sfpetclinic.services.jpa;

import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.repositories.PetRepository;
import ca.elikellendonk.sfpetclinic.services.PetService;

public class PetServiceJpa implements PetService {
  private final PetRepository pets;

  public PetServiceJpa(PetRepository pets) {
    this.pets = pets;
  }

  @Override
  public Pet findByName(String name) {
    return pets.findByName(name);
  }

  @Override
  public Pet findById(Long id) {
    return pets.findById(id).orElse(null);
  }

  @Override
  public Pet save(Pet o) {
    return pets.save(o);
  }

  @Override
  public Iterable<Pet> findAll() {
    return pets.findAll();
  }

  @Override
  public void delete(Pet o) {
    pets.delete(o);
  }

  @Override
  public void deleteById(Long id) {
    pets.deleteById(id);
  }

  @Override
  public long count() {
    return pets.count();
  }
}
