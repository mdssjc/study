package iterator;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {

    private Integer[] values;
    private int       index;

    public ArrayIterator(int[] values) {
        this.values = Arrays.stream(values)
                            .boxed()
                            .toArray(Integer[]::new);
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Integer next() {
        return values[index++];
    }

    @Override
    public void remove() {
        if (index <= 0) {
            throw new IllegalStateException();
        }

        if (values[index - 1] != null) {
            for (int i = index - 1; i < (values.length - 1); i++) {
                values[i] = values[i + 1];
            }
            values[values.length - 1] = null;
        }
    }
}
