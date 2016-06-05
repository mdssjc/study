package proxy;

import subject.Subject;
import subject.real.RealSubject;

public class VirtualProxy implements Subject {

  private final Subject subject = new RealSubject();

  @Override
  public void request() {
    System.out.println("Waiting for Subject");

    new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          Thread.sleep(5000);
        } catch (final InterruptedException e) {
          System.err.println(e.getMessage());
        }
        VirtualProxy.this.subject.request();
      }
    }).start();
  }

  @Override
  public void secretMessage() {
  }
}
