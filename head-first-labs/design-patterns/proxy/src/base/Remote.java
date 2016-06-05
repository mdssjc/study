package base;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import subject.real.Service;

public class Remote implements Runnable {

  @Override
  public void run() {
    try {
      final Service service = new Service();
      Naming.rebind("//localhost/proxy", service);
    } catch (final RemoteException e) {
      e.printStackTrace();
    } catch (final MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
