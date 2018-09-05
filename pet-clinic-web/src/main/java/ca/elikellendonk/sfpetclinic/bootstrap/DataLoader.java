package ca.elikellendonk.sfpetclinic.bootstrap;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.model.PetType;
import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final PetService petService;
  private final PetTypeService petTypeService;
  private final VetService vetService;

  public DataLoader(
      OwnerService ownerService,
      PetService petService,
      PetTypeService petTypeService,
      VetService vetService) {
    this.ownerService = ownerService;
    this.petService = petService;
    this.petTypeService = petTypeService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    PetType cat = createPetType("Cat");
    PetType dog = createPetType("Dog");

    createOwner("Joe", "Smith", new Pet[] {makePet("Ralph", dog)});
    createOwner("Jim", "Lee", new Pet[] {makePet("Fluffy", dog), makePet("Whiskers", cat)});

    createVet("Jill", "Frazier");
    createVet("Daniel", "Jackson");
  }

  private PetType createPetType(String name) {
    return petTypeService.save(makePetType(name));
  }

  private PetType makePetType(String name) {
    PetType petType = new PetType();
    petType.setName(name);

    return petType;
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

  private Pet makePet(String name, PetType petType) {
    Pet pet = new Pet();
    pet.setName(name);
    pet.setBirthDate(LocalDate.now());
    pet.setPetType(petType);

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
