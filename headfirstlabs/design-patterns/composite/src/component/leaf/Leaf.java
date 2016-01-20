package component.leaf;

import component.Component;

public class Leaf extends Component {

  private String message;

  public Leaf(String message) {
    this.message = message;
  }

  @Override
  public void print() {
    System.out.println(message);
  }
}
