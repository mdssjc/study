package aggregate;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import iterator.ArrayListIterator;

public class ArrayListStructure implements AggregateIterator {

    private List<Integer> values;

    public ArrayListStructure() {
        setValues(IntStream.range(0, 1000)
                           .limit(10)
                           .boxed()
                           .collect(Collectors.toList()));
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayListIterator(values);
    }

    @Override
    public void internalIterator(Consumer<? super Integer> consumer) {
        values.stream()
              .forEach(consumer);
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
