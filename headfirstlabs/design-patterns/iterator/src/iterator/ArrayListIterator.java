package iterator;

import java.util.Iterator;
import java.util.List;

public class ArrayListIterator implements Iterator<Integer> {

    private List<Integer> values;
    private int           index;

    public ArrayListIterator(List<Integer> values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.size();
    }

    @Override
    public Integer next() {
        return values.get(index++);
    }
}
