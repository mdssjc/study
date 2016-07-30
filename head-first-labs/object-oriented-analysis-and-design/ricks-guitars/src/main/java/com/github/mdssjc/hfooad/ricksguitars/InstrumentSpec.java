package com.github.mdssjc.hfooad.ricksguitars;

import java.util.HashMap;
import java.util.Iterator;
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

  public Iterator<String> getProperties() {
    return this.properties.keySet()
      .iterator();
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
    final Iterator<String> property = other.getProperties();
    if (!property.hasNext()) {
      return false;
    }
    while (property.hasNext()) {
      final String p = property.next();
      if (!getProperty(p).equals(other.getProperty(p))) {
        return false;
      }
    }
    return true;
  }
}
