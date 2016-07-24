package com.github.mdssjc.hfooad.ricksguitars;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * InstrumentSpec Class.
 * 
 * @author Marcelo dos Santos
 *
 */
public class InstrumentSpec {

  private final Map<String, Object> properties;

  public InstrumentSpec() {
    this.properties = new HashMap<>();
  }

  public InstrumentSpec addProperty(final String property, final Object value) {
    this.properties.put(property, value);
    return this;
  }

  public Object getProperty(final String property) {
    return this.properties.get(property);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.properties);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final InstrumentSpec other = (InstrumentSpec) obj;
    if (this.properties == null) {
      if (other.properties != null) {
        return false;
      }
    } else if (!this.properties.equals(other.properties)) {
      return false;
    }
    return true;
  }
}
