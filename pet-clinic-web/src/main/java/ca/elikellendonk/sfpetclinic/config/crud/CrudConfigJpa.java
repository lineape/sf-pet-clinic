package ca.elikellendonk.sfpetclinic.config.crud;

import ca.elikellendonk.sfpetclinic.repositories.OwnerRepository;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.jpa.OwnerServiceJpa;
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
}
