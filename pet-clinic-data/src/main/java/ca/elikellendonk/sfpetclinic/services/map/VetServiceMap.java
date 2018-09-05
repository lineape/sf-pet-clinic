package ca.elikellendonk.sfpetclinic.services.map;

import ca.elikellendonk.sfpetclinic.model.Specialty;
import ca.elikellendonk.sfpetclinic.model.Vet;
import ca.elikellendonk.sfpetclinic.services.SpecialtyService;
import ca.elikellendonk.sfpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet> implements VetService {
  private SpecialtyService specialtyService;

  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Vet save(Vet vet) {
    if (vet == null) {
      return null;
    }
    if (vet.isNew()) {
      vet.setId(generateId());
    }

    for (Specialty s : vet.getSpecialties()) {
      if (s.isNew()) {
        specialtyService.save(s);
      }
    }

    return save(vet.getId(), vet);
  }
}
