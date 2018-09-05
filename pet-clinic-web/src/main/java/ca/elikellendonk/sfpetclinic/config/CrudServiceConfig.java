package ca.elikellendonk.sfpetclinic.config;

import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.map.OwnerServiceMap;
import ca.elikellendonk.sfpetclinic.services.map.PetServiceMap;
import ca.elikellendonk.sfpetclinic.services.map.PetTypeServiceMap;
import ca.elikellendonk.sfpetclinic.services.map.VetServiceMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CrudServiceConfig {
  @Configuration
  @Profile({"local", "default"})
  static class CrudServiceMap {

    @Bean
    public OwnerService ownerService() {
      return new OwnerServiceMap();
    }

    @Bean
    public PetService petService() {
      return new PetServiceMap();
    }

    @Bean
    public PetTypeService petTypeService() {
      return new PetTypeServiceMap();
    }

    @Bean
    public VetService vetService() {
      return new VetServiceMap();
    }
  }
}
