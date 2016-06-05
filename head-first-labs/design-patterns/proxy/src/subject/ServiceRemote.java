package subject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceRemote extends Remote {

  String sayHello() throws RemoteException;
}
