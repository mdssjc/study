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

    public static final Consumer<? super Integer> OPERATION = System.out::println;

    public static void main(String[] args) {
        AggregateIterator dataArray = new ArrayStructure();
        AggregateIterator dataArrayList = new ArrayListStructure();

        Iterator<Integer> iteratorA = dataArray.createIterator();
        Iterator<Integer> iteratorB = dataArrayList.createIterator();

        System.out.println("-- 1 --");
        dataArray.internalIterator(OPERATION);

        System.out.println("-- 2 --");
        dataArrayList.internalIterator(OPERATION);

        System.out.println("-- 3 --");
        print(iteratorA);

        System.out.println("-- 4 --");
        print(iteratorB);
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
