package aggregate;

import java.util.Iterator;
import java.util.function.Consumer;

public interface AggregateIterator {

    Iterator<Integer> createIterator();

    void internalIterator(Consumer<? super Integer> consumer);
}
