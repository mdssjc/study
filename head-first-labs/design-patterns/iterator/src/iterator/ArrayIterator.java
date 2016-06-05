package iterator;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {

    private final Integer[] values;
    private int             index;

    public ArrayIterator(final int[] values) {
        this.values = Arrays.stream(values)
                            .boxed()
                            .toArray(Integer[]::new);
    }

    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }

    @Override
    public Integer next() {
        return this.values[this.index++];
    }

    @Override
    public void remove() {
        if (this.index <= 0) {
            throw new IllegalStateException();
        }

        if (this.values[this.index - 1] != null) {
            for (int i = this.index - 1; i < (this.values.length - 1); i++) {
                this.values[i] = this.values[i + 1];
            }
            this.values[this.values.length - 1] = null;
        }
    }
}
