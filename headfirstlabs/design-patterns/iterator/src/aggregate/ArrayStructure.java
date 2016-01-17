package aggregate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import iterator.ArrayIterator;

public class ArrayStructure implements AggregateIterator {

    private final int[] values;

    public ArrayStructure() {
        this.values = IntStream.range(0, 1000)
                               .limit(10)
                               .toArray();
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayIterator(this.values);
    }

    @Override
    public void internalIterator(final Consumer<? super Integer> consumer) {
        Arrays.stream(this.values)
              .boxed()
              .forEach(consumer);
    }
}
