package subject.real;

import subject.Subject;

public class RealSubject implements Subject {

  @Override
  public void request() {
    System.out.println("Real Subject");
  }

  @Override
  public void secretMessage() {
    System.out.println("My secret message!");
  }
}
