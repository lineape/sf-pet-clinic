package ca.elikellendonk.sfpetclinic.config.crud;

import ca.elikellendonk.sfpetclinic.repositories.OwnerRepository;
import ca.elikellendonk.sfpetclinic.repositories.PetRepository;
import ca.elikellendonk.sfpetclinic.repositories.VetRepository;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.jpa.OwnerServiceJpa;
import ca.elikellendonk.sfpetclinic.services.jpa.PetServiceJpa;
import ca.elikellendonk.sfpetclinic.services.jpa.VetServiceJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpa")
public class CrudConfigJpa {
  @Bean
  public OwnerService ownerService(OwnerRepository ownerRepository) {
    return new OwnerServiceJpa(ownerRepository);
  }

  @Bean
  public PetService petService(PetRepository petRepository) {
    return new PetServiceJpa(petRepository);
  }

  @Bean
  public VetService vetService(VetRepository vetRepository) {
    return new VetServiceJpa(vetRepository);
  }
}
