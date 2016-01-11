package aggregate;

import java.util.Iterator;
import java.util.stream.IntStream;

import iterator.ArrayIterator;

public class ArrayStructure implements AggregateIterator {

    private int[] values;

    public ArrayStructure() {
        setValues(IntStream.range(0, 1000)
                           .limit(10)
                           .toArray());
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayIterator(values);
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
}
