package iterator;

import java.util.Iterator;
import java.util.Map;

public class MapIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public MapIterator(final Map<String, Integer> values) {
        this.iterator = values.values()
                              .iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Integer next() {
        return this.iterator.next();
    }

    @Override
    public void remove() {
        this.iterator.remove();
    }
}
