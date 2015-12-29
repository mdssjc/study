package subsystem;

import java.util.Random;

public class SubsystemB {

    private double result;

    public void doCalc() {
        result = new Random().nextInt(1000) / Math.PI;
    }

    public double getResult() {
        return result;
    }
}
