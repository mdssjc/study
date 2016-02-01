/*
 * Design Pattern
 * Structural - Proxy (Surrogate)
 *
 * rmic -classpath . subject.real.Service
 * rmiregistry
 */
package base;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import subject.real.Service;

public class Main {

  public static void main(final String[] args) {

    try {
      final Service service = new Service();
      Naming.rebind("proxy", service);
    } catch (final RemoteException e) {
      e.printStackTrace();
    } catch (final MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
