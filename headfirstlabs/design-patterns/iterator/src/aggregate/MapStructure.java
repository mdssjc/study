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

        values = IntStream.range(0, 1000)
                          .limit(10)
                          .boxed()
                          .collect(Collectors.toMap(i -> i.toString(),
                                  i -> (Integer) i));
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new MapIterator(values);
    }

    @Override
    public void internalIterator(Consumer<? super Integer> consumer) {
        values.values()
              .stream()
              .forEach(consumer);
    }
}
