package component.composite;

import java.util.ArrayList;
import java.util.List;

import component.Component;

public class Composite extends Component {

  private List<Component> components;
  private String          message;

  public Composite() {
    this.components = new ArrayList<>();
  }

  public Composite(String message) {
    this();
    this.message = message;
  }

  @Override
  public void add(Component component) {
    this.components.add(component);
  }

  @Override
  public void remove(Component component) {
    this.components.remove(component);
  }

  @Override
  public Component getChild(int i) {
    return this.components.get(i);
  }

  @Override
  public void print() {
    System.out.println(message);
    for (Component component : components) {
      component.print();
    }
  }
}
