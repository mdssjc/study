package component;

public abstract class Component {

  public void add(Component component) {
    throw new UnsupportedOperationException();
  }

  public void remove(Component component) {
    throw new UnsupportedOperationException();
  }

  public Component getChild(int i) {
    throw new UnsupportedOperationException();
  }

  public void print() {
    throw new UnsupportedOperationException();
  }
}
