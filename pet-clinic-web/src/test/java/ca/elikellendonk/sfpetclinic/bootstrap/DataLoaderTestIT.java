package ca.elikellendonk.sfpetclinic.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.elikellendonk.sfpetclinic.SfPetClinicApplication;
import ca.elikellendonk.sfpetclinic.config.crud.CrudConfigJpa;
import ca.elikellendonk.sfpetclinic.services.OwnerService;
import ca.elikellendonk.sfpetclinic.services.PetService;
import ca.elikellendonk.sfpetclinic.services.PetTypeService;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;
import ca.elikellendonk.sfpetclinic.services.VisitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SfPetClinicApplication.class, CrudConfigJpa.class})
@DataJpaTest
public class DataLoaderTestIT {
  @Autowired private OwnerService owners;
  @Autowired private PetTypeService petTypes;
  @Autowired private PetService pets;
  @Autowired private SpecialtyService specialties;
  @Autowired private VetService vets;
  @Autowired private VisitService visits;

  @Test
  public void seedAll() {
    new DataLoader(owners, petTypes, pets, specialties, vets, visits).seedAll();

    assertEquals(3, owners.count());
    assertEquals(3, petTypes.count());
    assertEquals(4, pets.count());
    assertEquals(3, specialties.count());
    assertEquals(2, vets.count());
    assertEquals(3, visits.count());
  }
}
