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
    Owner owner1 = new Owner();
    owner1.setFirstName("Joe");
    owner1.setLastName("Smith");

    Pet pet1 = new Pet();
    pet1.setOwner(owner1);
    pet1.setBirthDate(LocalDate.now());

    owner1.getPets().add(pet1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Jim");
    owner2.setLastName("Lee");

    Pet pet2 = new Pet();
    pet2.setOwner(owner2);
    pet2.setBirthDate(LocalDate.now());

    owner2.getPets().add(pet2);

    ownerService.save(owner1);
    ownerService.save(owner2);

    petService.save(pet1);
    petService.save(pet2);

    Vet vet1 = new Vet();
    vet1.setFirstName("Jill");
    vet1.setLastName("Frazier");

    Vet vet2 = new Vet();
    vet2.setFirstName("Daniel");
    vet2.setLastName("Jackson");

    vetService.save(vet1);
    vetService.save(vet2);
  }
}
