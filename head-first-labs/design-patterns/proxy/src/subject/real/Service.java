package subject.real;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import subject.ServiceRemote;

public class Service extends UnicastRemoteObject implements ServiceRemote {

  public Service() throws RemoteException {
    super();
  }

  private static final long serialVersionUID = 1L;

  @Override
  public String sayHello() throws RemoteException {
    return "Hello World!";
  }
}
