package com.github.mdssjc.design_patterns.structural.facade;

import com.github.mdssjc.dp.facade.subsystem.SubsystemA;
import com.github.mdssjc.dp.facade.subsystem.SubsystemB;
import com.github.mdssjc.dp.facade.subsystem.SubsystemC;

/**
 * Facade.
 *
 * @author Marcelo dos Santos
 *
 */
public class Facade {

  public String message1() {
    final SubsystemA subsystemA = new SubsystemA();
    subsystemA.setMessage("SS A");
    return subsystemA.getMessage();
  }

  public String message2() {
    final SubsystemB subsystemB = new SubsystemB();
    subsystemB.doCalc();
    return String.format("result: %.2f", subsystemB.getResult());
  }

  public int message3() {
    final SubsystemC subsystemC = new SubsystemC();
    subsystemC.insert(1);
    subsystemC.insert(2);
    subsystemC.insert(3);
    return subsystemC.doResult();
  }
}
