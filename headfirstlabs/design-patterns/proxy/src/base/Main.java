/*
 * Design Pattern
 * Structural - Proxy (Surrogate)
 *
 * project/bin
 * rmic -classpath . subject.real.Service
 * rmiregistry
 */
package base;

import proxy.ProtectionProxy;
import proxy.VirtualProxy;
import subject.Subject;

public class Main {

  public static void main(final String[] args) throws Exception {
    // Remote Proxy
    System.setProperty("java.rmi.server.hostname", "localhost");

    final Thread remote = new Thread(new Remote());
    final Thread monitor = new Thread(new Monitor());

    System.out.println("remote");
    remote.start();
    System.out.println("sleeping by 1s");
    Thread.sleep(1000);
    System.out.println("local");
    monitor.start();

    // Virtual Proxy
    final Subject virtual = new VirtualProxy();
    virtual.request();
    System.out.println("Waiting...");
    Thread.sleep(1000);
    System.out.println("Waiting...");
    Thread.sleep(1000);

    // Protection Proxy (Java: Dynamic Proxy)
    final Subject proxy = new ProtectionProxy().getProxy("RealSubject");
    proxy.request();
    try {
      proxy.secretMessage();
    } catch (final Exception e) {
      System.err.println(e.getCause()
                          .getMessage());
    }
  }
}
