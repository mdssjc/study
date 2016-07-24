package com.github.mdssjc.hfooad.ricksguitars;

import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;

/**
 * InstrumentSpec Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@EqualsAndHashCode
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
}
