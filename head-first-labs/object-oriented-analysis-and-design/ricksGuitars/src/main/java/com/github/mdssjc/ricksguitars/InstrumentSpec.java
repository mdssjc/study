package com.github.mdssjc.ricksguitars;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class InstrumentSpec {

  private final Map<String, Object> properties;

  public InstrumentSpec(final Map properties) {
    if (properties == null) {
      this.properties = new HashMap<>();
    } else {
      this.properties = new HashMap<>(properties);
    }
  }

  public Object getProperty(final String propertyName) {
    return this.properties.get(propertyName);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof InstrumentSpec)) {
      return false;
    }

    return Objects.equals(this.properties, ((InstrumentSpec) o).properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.properties);
  }
}
