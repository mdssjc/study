package com.github.mdssjc.gsf.unit;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class Unit {

  private final int id;
  private String type;
  private String name;
  private List<Weapon> weapons;
  private Map<String, Object> properties;

  public void addWeapon(final Weapon weapon) {
    if (this.weapons == null) {
      this.weapons = new LinkedList<>();
    }
    this.weapons.add(weapon);
  }

  public List<Weapon> getWeapons() {
    return this.weapons;
  }

  public void setProperty(final String property, final Object value) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(property, value);
  }

  public Object getProperty(final String property) {
    if (this.properties == null) {
      throw new IllegalArgumentException("No properties for this Unit.");
    }
    final Object value = this.properties.get(property);
    if (value == null) {
      throw new IllegalArgumentException("Request for non-existent property.");
    }
    return value;
  }
}
