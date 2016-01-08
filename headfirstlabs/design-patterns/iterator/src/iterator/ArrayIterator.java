package iterator;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {

    private int[] values;
    private int   index;

    public ArrayIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Integer next() {
        return values[index++];
    }
}
