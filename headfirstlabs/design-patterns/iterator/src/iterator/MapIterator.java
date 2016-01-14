package iterator;

import java.util.Iterator;
import java.util.Map;

public class MapIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public MapIterator(Map<String, Integer> values) {
        this.iterator = values.values()
                              .iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
