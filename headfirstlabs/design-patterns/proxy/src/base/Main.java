/*
 * Design Pattern
 * Structural - Proxy (Surrogate)
 *
 * project/bin
 * rmic -classpath . subject.real.Service
 * rmiregistry
 */
package base;

public class Main {

  public static void main(final String[] args) throws Exception {
    System.setProperty("java.rmi.server.hostname", "localhost");

    final Thread remote = new Thread(new Remote());
    final Thread monitor = new Thread(new Monitor());

    System.out.println("remote");
    remote.start();
    System.out.println("sleeping by 1s");
    Thread.sleep(1000);
    System.out.println("local");
    monitor.start();
  }
}
