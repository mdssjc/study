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
import aggregate.MapStructure;

public class Main {

    public static final Consumer<? super Integer> OPERATION = System.out::println;

    public static void main(String[] args) {
        final AggregateIterator dataArray = new ArrayStructure();
        final AggregateIterator dataArrayList = new ArrayListStructure();
        final AggregateIterator dataMap = new MapStructure();

        final Iterator<Integer> iteratorA = dataArray.createIterator();
        final Iterator<Integer> iteratorB = dataArrayList.createIterator();
        final Iterator<Integer> iteratorC = dataMap.createIterator();

        System.out.println("-- 1 --");
        dataArray.internalIterator(Main.OPERATION);

        System.out.println("-- 2 --");
        dataArrayList.internalIterator(Main.OPERATION);

        System.out.println("-- 3 --");
        dataMap.internalIterator(Main.OPERATION);

        System.out.println("-- 4 --");
        Main.print(iteratorA);

        System.out.println("-- 5 --");
        Main.print(iteratorB);

        System.out.println("-- 6 --");
        Main.print(iteratorC);
    }

    /**
     * External Iterator
     *
     * @param iterator
     */
    private static void print(final Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
