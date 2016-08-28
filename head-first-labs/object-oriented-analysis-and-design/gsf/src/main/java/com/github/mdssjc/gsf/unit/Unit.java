package com.github.mdssjc.gsf.unit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Unit {

  @Getter
  @Setter
  private String              type;
  @Getter
  private final int           id;
  @Getter
  @Setter
  private String              name;
  private List<Weapon>        weapons;
  private Map<String, Object> properties;

  public Unit(final int id) {
    this.id = id;
  }

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
      return null;
    }
    return this.properties.get(property);
  }
}
