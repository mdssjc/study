package com.github.mdssjc.dogdoors;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BarkManager {

  private final List<Bark> barks;

  public BarkManager() {
    this.barks = new LinkedList<>();
  }

  public void addAllowedBark(final Bark allowedBark) {
    this.barks.add(allowedBark);
  }

  public Iterator<Bark> getAllowedBarks() {
    return this.barks.iterator();
  }
}
