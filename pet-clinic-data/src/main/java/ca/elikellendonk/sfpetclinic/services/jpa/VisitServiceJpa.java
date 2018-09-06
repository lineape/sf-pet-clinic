package ca.elikellendonk.sfpetclinic.services.jpa;

import ca.elikellendonk.sfpetclinic.model.Visit;
import ca.elikellendonk.sfpetclinic.repositories.VisitRepository;
import ca.elikellendonk.sfpetclinic.services.VisitService;

public class VisitServiceJpa implements VisitService {
  private final VisitRepository visits;

  public VisitServiceJpa(VisitRepository visits) {
    this.visits = visits;
  }

  @Override
  public Visit findById(Long id) {
    return visits.findById(id).orElse(null);
  }

  @Override
  public Visit save(Visit o) {
    return visits.save(o);
  }

  @Override
  public Iterable<Visit> findAll() {
    return visits.findAll();
  }

  @Override
  public void delete(Visit o) {
    visits.delete(o);
  }

  @Override
  public void deleteById(Long id) {
    visits.deleteById(id);
  }

  @Override
  public long count() {
    return visits.count();
  }
}
