package com.github.mdssjc.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class GumballMachineTestDrive {

  public static void main(final String[] args) {
    final int count;

    if (args.length < 2) {
      System.out.println("GumballMachine <name> <inventory>");
      System.exit(1);
    }

    try {
      count = Integer.parseInt(args[1]);
      final GumballMachine gumballMachine = new GumballMachine(args[0], count);
      Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
      final GumballMonitor monitor = new GumballMonitor(gumballMachine);

      System.out.println(gumballMachine);

      gumballMachine.insertQuarter();
      gumballMachine.turnCrank();

      System.out.println(gumballMachine);

      gumballMachine.insertQuarter();
      gumballMachine.ejectQuarter();
      gumballMachine.turnCrank();

      System.out.println(gumballMachine);

      gumballMachine.insertQuarter();
      gumballMachine.turnCrank();
      gumballMachine.insertQuarter();
      gumballMachine.turnCrank();
      gumballMachine.ejectQuarter();

      System.out.println(gumballMachine);

      gumballMachine.insertQuarter();
      gumballMachine.insertQuarter();
      gumballMachine.turnCrank();
      gumballMachine.insertQuarter();
      gumballMachine.turnCrank();
      gumballMachine.insertQuarter();
      gumballMachine.turnCrank();

      System.out.println(gumballMachine);

      monitor.report();
    } catch (RemoteException | MalformedURLException e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }
}
