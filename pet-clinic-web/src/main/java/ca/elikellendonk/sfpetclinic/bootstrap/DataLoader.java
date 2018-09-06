package ca.elikellendonk.sfpetclinic.bootstrap;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.model.PetType;
import ca.elikellendonk.sfpetclinic.model.Specialty;
import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final PetService petService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;
  private final VetService vetService;

  public DataLoader(
      OwnerService ownerService,
      PetService petService,
      PetTypeService petTypeService,
      SpecialtyService specialtyService,
      VetService vetService) {
    this.ownerService = ownerService;
    this.petService = petService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    if (ownerService.count() == 0) {
      seedOwnersAndPets();
    }
    if (vetService.count() == 0) {
      seedVetsAndSpecialties();
    }
  }

  private void seedOwnersAndPets() {
    PetType cat = petTypeService.save(makePetType("Cat"));
    PetType dog = petTypeService.save(makePetType("Dog"));

    Owner owner1 = makeOwner("Joe", "Smith", "123 Avenue", "New york", "444-222-3333");
    owner1.getPets().add(petService.save(makePet("Ralph", dog)));

    Owner owner2 = makeOwner("Jim", "Lee", "123 street", "Toronto", "444-333-2222");
    owner2.getPets().add(petService.save(makePet("Fluffy", dog)));
    owner2.getPets().add(petService.save(makePet("Whiskers", cat)));

    ownerService.save(owner1);
    ownerService.save(owner2);
  }

  private void seedVetsAndSpecialties() {
    Specialty goodWithCats = specialtyService.save(makeSpecialty("Cats", "Good with cats"));
    Specialty goodWithDogs = specialtyService.save(makeSpecialty("Dogs", "Good with dogs"));

    Vet vet1 = vetService.save(makeVet("Jill", "Frazier"));
    vet1.getSpecialties().add(goodWithCats);

    Vet vet2 = vetService.save(makeVet("Daniel", "Jackson"));
    vet2.getSpecialties().add(goodWithCats);
    vet2.getSpecialties().add(goodWithDogs);

    vetService.save(vet1);
    vetService.save(vet2);
  }

  private PetType makePetType(String name) {
    PetType petType = new PetType();
    petType.setName(name);

    return petType;
  }

  private Owner makeOwner(
      String firstName, String lastName, String address, String city, String telephone) {
    Owner owner = new Owner();
    owner.setFirstName(firstName);
    owner.setLastName(lastName);
    owner.setAddress(address);
    owner.setCity(city);
    owner.setTelephone(telephone);

    return owner;
  }

  private Pet makePet(String name, PetType petType) {
    Pet pet = new Pet();
    pet.setName(name);
    pet.setBirthDate(LocalDate.now());
    pet.setPetType(petType);

    return pet;
  }

  private Vet makeVet(String firstName, String lastName) {
    Vet vet = new Vet();
    vet.setFirstName(firstName);
    vet.setLastName(lastName);

    return vet;
  }

  private Specialty makeSpecialty(String name, String description) {
    Specialty specialty = new Specialty();
    specialty.setName(name);
    specialty.setDescription(description);

    return specialty;
  }
}
