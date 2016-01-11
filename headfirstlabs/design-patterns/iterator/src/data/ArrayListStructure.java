package data;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import iterator.ArrayListIterator;

public class ArrayListStructure implements DataIterator {

    private List<Integer> values;

    public ArrayListStructure() {
        setValues(IntStream.range(0, 1000)
                           .limit(10)
                           .boxed()
                           .collect(Collectors.toList()));
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayListIterator(getValues());
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
