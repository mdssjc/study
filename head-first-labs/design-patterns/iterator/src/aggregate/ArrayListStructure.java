package aggregate;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import iterator.ArrayListIterator;

public class ArrayListStructure implements AggregateIterator {

    private final List<Integer> values;

    public ArrayListStructure() {
        this.values = IntStream.range(0, 1000)
                               .limit(10)
                               .boxed()
                               .collect(Collectors.toList());
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayListIterator(this.values);
    }

    @Override
    public void internalIterator(final Consumer<? super Integer> consumer) {
        this.values.stream()
                   .forEach(consumer);
    }
}
