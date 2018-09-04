package ca.elikellendonk.sfpetclinic.model;

import java.io.Serializable;
import java.util.StringJoiner;

public abstract class BaseEntity implements Serializable {
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean isNew() {
    return id == null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BaseEntity that = (BaseEntity) o;

    return isNew() ? id.equals(that.id) : that.isNew();
  }

  @Override
  public int hashCode() {
    return !isNew() ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", getClass() + "[", "]").add("id=" + id).toString();
  }
}
