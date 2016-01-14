package aggregate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import iterator.ArrayIterator;

public class ArrayStructure implements AggregateIterator {

    private int[] values;

    public ArrayStructure() {
        values = IntStream.range(0, 1000)
                          .limit(10)
                          .toArray();
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayIterator(values);
    }

    @Override
    public void internalIterator(Consumer<? super Integer> consumer) {
        Arrays.stream(values)
              .boxed()
              .forEach(consumer);
    }
}
