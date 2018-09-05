package ca.elikellendonk.sfpetclinic.bootstrap;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final PetService petService;
  private final VetService vetService;
  private final OwnerService ownerService;

  public DataLoader(PetService petService, VetService vetService, OwnerService ownerService) {
    this.petService = petService;
    this.vetService = vetService;
    this.ownerService = ownerService;
  }

  @Override
  public void run(String... args) throws Exception {
    createOwner("Joe", "Smith", new Pet[] {makePet("Ralph")});
    createOwner("Jim", "Lee", new Pet[] {makePet("Fluffy"), makePet("Whiskers")});

    createVet("Jill", "Frazier");
    createVet("Daniel", "Jackson");
  }

  private Owner createOwner(String firstName, String lastName, Pet[] pets) {
    Owner owner = makeOwner(firstName, lastName);

    for (Pet pet : pets) {
      owner.getPets().add(pet);
      pet.setOwner(owner);
      petService.save(pet);
    }

    return ownerService.save(owner);
  }

  private Owner makeOwner(String firstName, String lastName) {
    Owner owner = new Owner();
    owner.setFirstName(firstName);
    owner.setLastName(lastName);

    return owner;
  }

  private Pet makePet(String name) {
    Pet pet = new Pet();
    pet.setName(name);
    pet.setBirthDate(LocalDate.now());

    return pet;
  }

  private Vet createVet(String firstName, String lastName) {
    return vetService.save(makeVet(firstName, lastName));
  }

  private Vet makeVet(String firstName, String lastName) {
    Vet vet = new Vet();
    vet.setFirstName(firstName);
    vet.setLastName(lastName);

    return vet;
  }
}
