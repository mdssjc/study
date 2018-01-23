package com.github.mdssjc.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite.
 *
 * @author Marcelo dos Santos
 *
 */
public class Composite implements Component{

  private final List<Component> childs;

  public Composite() {
    this.childs = new ArrayList<>();
  }

  @Override
  public void operation() {
    System.out.println("Composite");
    this.childs.forEach(Component::operation);
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