package contexts;

import algorithms.Algorithm;
import algorithms.NullAlgorithm;

public abstract class ImpX {
    private Algorithm algorithm;

    public ImpX() {
        // Null Object Pattern
        this.algorithm = new NullAlgorithm();
    }

    public void setAlg(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void useAlgorithm() {
        algorithm.execute();
    }
}
