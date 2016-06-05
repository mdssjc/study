package facade;

import subsystem.SubsystemA;
import subsystem.SubsystemB;
import subsystem.SubsystemC;

public class Facade {

    public void message1() {
        SubsystemA subsystemA = new SubsystemA();
        subsystemA.setMessage("SS A");
        System.out.println(subsystemA.getMessage());
    }

    public void message2() {
        SubsystemB subsystemB = new SubsystemB();
        subsystemB.doCalc();
        System.out.println(String.format("result: %.2f", subsystemB.getResult()));
    }

    public void message3() {
        SubsystemC subsystemC = new SubsystemC();
        subsystemC.insert(1);
        subsystemC.insert(2);
        subsystemC.insert(3);
        System.out.println(subsystemC.doResult());
    }
}
