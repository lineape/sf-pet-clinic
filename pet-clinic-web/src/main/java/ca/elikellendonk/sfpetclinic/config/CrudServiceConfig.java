package ca.elikellendonk.sfpetclinic.config;

import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.map.OwnerServiceMap;
import ca.elikellendonk.sfpetclinic.services.map.PetServiceMap;
import ca.elikellendonk.sfpetclinic.services.map.PetTypeServiceMap;
import ca.elikellendonk.sfpetclinic.services.map.SpecialtyServiceMap;
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
    public OwnerService ownerService(PetService petService) {
      return new OwnerServiceMap(petService);
    }

    @Bean
    public PetService petService(PetTypeService petTypeService) {
      return new PetServiceMap(petTypeService);
    }

    @Bean
    public PetTypeService petTypeService() {
      return new PetTypeServiceMap();
    }

    @Bean
    public SpecialtyService specialtyService() {
      return new SpecialtyServiceMap();
    }

    @Bean
    public VetService vetService(SpecialtyService specialtyService) {
      return new VetServiceMap(specialtyService);
    }
  }
}
