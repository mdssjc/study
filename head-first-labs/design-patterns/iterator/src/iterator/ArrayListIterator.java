package iterator;

import java.util.Iterator;
import java.util.List;

public class ArrayListIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public ArrayListIterator(final List<Integer> values) {
        this.iterator = values.iterator();
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
