package ca.elikellendonk.sfpetclinic.bootstrap;

import ca.elikellendonk.sfpetclinic.model.Owner;
import ca.elikellendonk.sfpetclinic.model.Pet;
import ca.elikellendonk.sfpetclinic.model.PetType;
import ca.elikellendonk.sfpetclinic.model.Specialty;
import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.model.Visit;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.VisitService;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
  private final OwnerService owners;
  private final PetTypeService petTypes;
  private final PetService pets;
  private final SpecialtyService specialties;
  private final VetService vets;
  private final VisitService visits;

  public DataLoader(
      OwnerService owners,
      PetTypeService petTypes,
      PetService pets,
      SpecialtyService specialties,
      VetService vets,
      VisitService visits) {
    this.owners = owners;
    this.petTypes = petTypes;
    this.pets = pets;
    this.specialties = specialties;
    this.vets = vets;
    this.visits = visits;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (petTypes.count() == 0) {
      seedPetTypesOwnersAndPets();
    }

    if (specialties.count() == 0) {
      seedSpecialtiesAndVets();
    }

    if (visits.count() == 0) {
      seedVisits();
    }
  }

  private void seedPetTypesOwnersAndPets() {
    PetType cat = petTypes.save(new PetType("Cat"));
    PetType dog = petTypes.save(new PetType("Dog"));

    Owner owner1 = new Owner("Joe", "Smith", "123 Avenue", "New york", "444-222-3333");
    owner1.addPet(new Pet("Ralph", LocalDate.now(), dog));

    Owner owner2 = new Owner("Jim", "Lee", "123 street", "Toronto", "444-333-2222");
    owner2.addPet(new Pet("Fluffy", LocalDate.now(), dog));
    owner2.addPet(new Pet("Whiskers", LocalDate.now(), cat));

    owners.save(owner1);
    owners.save(owner2);
  }

  private void seedSpecialtiesAndVets() {
    Specialty cats = specialties.save(new Specialty("Cats", "Good with cats"));
    Specialty dogs = specialties.save(new Specialty("Dogs", "Good with dogs"));

    Vet vet1 = new Vet("Jill", "Frazier");
    vet1.addSpecialty(cats);

    Vet vet2 = new Vet("Daniel", "Jackson");
    vet2.addSpecialty(cats);
    vet2.addSpecialty(dogs);

    vets.save(vet1);
    vets.save(vet2);
  }

  private void seedVisits() {
    Visit visit1 = new Visit("Ralph is sick!");
    visit1.setPet(pets.findByName("Ralph"));
    visit1.setVet(vets.findByFirstNameAndLastName("Daniel", "Jackson"));

    Visit visit2 = new Visit("Whiskers has a hairball!");
    visit2.setPet(pets.findByName("Whiskers"));
    visit2.setVet(vets.findByLastName("Frazier"));

    visits.save(visit1);
    visits.save(visit2);
  }
}
