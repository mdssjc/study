package subsystem;

import java.util.Arrays;

public class SubsystemC {

    private static final int LEN = 12;
    private int[]            result;
    private int              index;

    public SubsystemC() {
        result = new int[LEN];
        index = 0;
    }

    public void insert(int i) {
        result[index] = i;
        index++;
        index = index % LEN;
    }

    public int doResult() {
        return Arrays.stream(result)
                     .sum();
    }
}
