/*
 * Design Pattern
 * Behavioral - Iterator (Cursor)
 *
 */
package base;

import java.util.Iterator;
import java.util.function.Consumer;

import aggregate.AggregateIterator;
import aggregate.ArrayListStructure;
import aggregate.ArrayStructure;

public class Main {

    public static void main(String[] args) {
        AggregateIterator dataArray = new ArrayStructure();
        AggregateIterator dataArrayList = new ArrayListStructure();

        Iterator<Integer> iteratorA = dataArray.createIterator();
        Iterator<Integer> iteratorB = dataArrayList.createIterator();

        System.out.println("-- 1 --");
        dataArray.internalIterator(print());

        System.out.println("-- 2 --");
        dataArrayList.internalIterator(print());

        System.out.println("-- 3 --");
        print(iteratorA);

        System.out.println("-- 4 --");
        print(iteratorB);
    }

    /**
     * Consumer to Internal Iterator
     *
     * @return consumer
     */
    public static Consumer<? super Integer> print() {
        return System.out::println;
    }

    /**
     * External Iterator
     *
     * @param iterator
     */
    private static void print(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
