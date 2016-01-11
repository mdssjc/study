package iterator;

import java.util.Iterator;
import java.util.List;

public class ArrayListIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public ArrayListIterator(List<Integer> values) {
        this.iterator = values.iterator();
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
