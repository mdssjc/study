package aggregate;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import iterator.MapIterator;

public class MapStructure implements AggregateIterator {

    Map<String, Integer> values;

    public MapStructure() {

        this.values = IntStream.range(0, 1000)
                               .limit(10)
                               .boxed()
                               .collect(Collectors.toMap(i -> i.toString(),
                                       i -> i));
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new MapIterator(this.values);
    }

    @Override
    public void internalIterator(final Consumer<? super Integer> consumer) {
        this.values.values()
                   .stream()
                   .forEach(consumer);
    }
}
