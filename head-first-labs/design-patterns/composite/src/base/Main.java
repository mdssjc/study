/*
 * Design Pattern
 * Structural - Composite
 *
 */

package base;

import component.Component;
import component.composite.Composite;
import component.leaf.Leaf;

public class Main {

  public static void main(String[] args) {
    Component root = new Composite("Main");
    root.add(new Leaf("Leaf 1"));
    Component branch = new Composite("Branch");
    branch.add(new Leaf("Leaf 2"));
    branch.add(new Leaf("Leaf 3"));
    root.add(branch);

    root.print();
  }
}
