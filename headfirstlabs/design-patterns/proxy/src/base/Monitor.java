package base;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import subject.ServiceRemote;

public class Monitor implements Runnable {

  private ServiceRemote service;

  @Override
  public void run() {
    try {
      this.service = (ServiceRemote) Naming.lookup("rmi://localhost/proxy");
      final String sayHello = this.service.sayHello();
      System.out.println(sayHello);
    } catch (final MalformedURLException e) {
      e.printStackTrace();
    } catch (final RemoteException e) {
      e.printStackTrace();
    } catch (final NotBoundException e) {
      e.printStackTrace();
    }
  }
}
