package com.github.mdssjc.gumball;

import java.rmi.RemoteException;
import java.util.logging.Logger;

public class GumballMonitor {

  private final GumballMachineRemote machine;

  public GumballMonitor(final GumballMachineRemote machine) {
    this.machine = machine;
  }

  public void report() {
    try {
      System.out.println("Gumball Machine: " + this.machine.getLocation());
      System.out.println("Current inventory: " +
                         this.machine.getCount() + " gumballs");
      System.out.println("Current state: " + this.machine.getState());
    } catch (final RemoteException e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }
}
