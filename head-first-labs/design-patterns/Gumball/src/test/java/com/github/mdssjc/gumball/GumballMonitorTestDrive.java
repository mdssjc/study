package com.github.mdssjc.gumball;

import java.rmi.Naming;
import java.util.logging.Logger;

public class GumballMonitorTestDrive {

  public static void main(final String[] args) {
    // final String[] location = {
    //     "rmi://127.0.0.1/gumballmachine",
    //     "rmi://santafe.mightygumball.com/gumballmachine",
    //     "rmi://boulder.mightygumball.com/gumballmachine",
    //     "rmi://seattle.mightygumball.com/gumballmachine"};

    final String[] location = {"rmi://127.0.0.1/gumballmachine"};

    final GumballMonitor[] monitor = new GumballMonitor[location.length];

    for (int i = 0; i < location.length; i++) {
      try {
        final GumballMachineRemote machine =
            (GumballMachineRemote) Naming.lookup(location[i]);
        monitor[i] = new GumballMonitor(machine);
        System.out.println(monitor[i]);
      } catch (final Exception e) {
        Logger.getGlobal()
              .info(e.getMessage());
      }
    }

    for (final GumballMonitor m : monitor) {
      m.report();
    }
  }
}
