package ca.elikellendonk.sfpetclinic.config.crud;

import ca.elikellendonk.sfpetclinic.repositories.OwnerRepository;
import ca.elikellendonk.sfpetclinic.repositories.PetRepository;
import ca.elikellendonk.sfpetclinic.repositories.PetTypeRepository;
import ca.elikellendonk.sfpetclinic.repositories.SpecialtyRepository;
import ca.elikellendonk.sfpetclinic.repositories.VetRepository;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.jpa.OwnerServiceJpa;
import ca.elikellendonk.sfpetclinic.services.jpa.PetServiceJpa;
import ca.elikellendonk.sfpetclinic.services.jpa.PetTypeServiceJpa;
import ca.elikellendonk.sfpetclinic.services.jpa.SpecialtyServiceJpa;
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
  public PetTypeService petTypeService(PetTypeRepository petTypeRepository) {
    return new PetTypeServiceJpa(petTypeRepository);
  }

  @Bean
  public SpecialtyService vetService(SpecialtyRepository specialtyRepository) {
    return new SpecialtyServiceJpa(specialtyRepository);
  }

  @Bean
  public VetService vetService(VetRepository vetRepository) {
    return new VetServiceJpa(vetRepository);
  }
}
