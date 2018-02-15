package com.github.mdssjc.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Composite.
 *
 * @author Marcelo dos Santos
 *
 */
public class Composite implements Component {

  private final List<Component> childs;

  public Composite() {
    this.childs = new ArrayList<>();
  }

  @Override
  public String operation() {
    return "Composite " +
           this.childs.stream()
                      .map(Component::operation)
                      .collect(Collectors.joining(" "));
  }

  @Override
  public void add(final Component component) {
    this.childs.add(component);
  }

  @Override
  public void remove(final Component component) {
    this.childs.remove(component);
  }

  @Override
  public Component getChild(final int id) {
    return this.childs.get(id);
  }
}
