package ca.elikellendonk.sfpetclinic.bootstrap;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.model.PetType;
import ca.elikellendonk.sfpetclinic.model.Specialty;
import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.VisitService;
import java.time.LocalDate;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
  private final OwnerService owners;
  private final PetTypeService petTypes;
  private final SpecialtyService specialties;
  private final VetService vets;
  private final VisitService visits;

  public DataLoader(
      OwnerService owners,
      PetTypeService petTypes,
      SpecialtyService specialties,
      VetService vets,
      VisitService visits) {
    this.owners = owners;
    this.petTypes = petTypes;
    this.specialties = specialties;
    this.vets = vets;
    this.visits = visits;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (petTypes.count() == 0) {
      seedOwnersAndPets();
    }

    if (specialties.count() == 0) {
      seedVetsAndSpecialties();
    }
  }

  private void seedOwnersAndPets() {
    PetType cat = petTypes.save(makePetType("Cat"));
    PetType dog = petTypes.save(makePetType("Dog"));

    Owner owner1 = makeOwner("Joe", "Smith", "123 Avenue", "New york", "444-222-3333");
    owner1.addPet(makePet("Ralph", dog));

    Owner owner2 = makeOwner("Jim", "Lee", "123 street", "Toronto", "444-333-2222");
    owner2.addPet(makePet("Fluffy", dog));
    owner2.addPet(makePet("Whiskers", cat));

    owners.save(owner1);
    owners.save(owner2);
  }

  private void seedVetsAndSpecialties() {
    Specialty goodWithCats = specialties.save(makeSpecialty("Cats", "Good with cats"));
    Specialty goodWithDogs = specialties.save(makeSpecialty("Dogs", "Good with dogs"));

    Vet vet1 = makeVet("Jill", "Frazier");
    vet1.addSpecialty(goodWithCats);

    Vet vet2 = makeVet("Daniel", "Jackson");
    vet2.addSpecialty(goodWithCats);
    vet2.addSpecialty(goodWithDogs);

    vets.save(vet1);
    vets.save(vet2);
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
