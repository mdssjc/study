package com.github.mdssjc.dp.facade;

import com.github.mdssjc.dp.facade.subsystem.SubsystemA;
import com.github.mdssjc.dp.facade.subsystem.SubsystemB;
import com.github.mdssjc.dp.facade.subsystem.SubsystemC;

/**
 * Implementação do Facade.
 *
 * @author Marcelo dos Santos
 *
 */
public class Facade {

  public void message1() {
    final SubsystemA subsystemA = new SubsystemA();
    subsystemA.setMessage("SS A");
    System.out.println(subsystemA.getMessage());
  }

  public void message2() {
    final SubsystemB subsystemB = new SubsystemB();
    subsystemB.doCalc();
    System.out.println(String.format("result: %.2f", subsystemB.getResult()));
  }

  public void message3() {
    final SubsystemC subsystemC = new SubsystemC();
    subsystemC.insert(1);
    subsystemC.insert(2);
    subsystemC.insert(3);
    System.out.println(subsystemC.doResult());
  }
}
