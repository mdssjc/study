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
        AggregateIterator dataArray = new ArrayStructure();
        AggregateIterator dataArrayList = new ArrayListStructure();
        AggregateIterator dataMap = new MapStructure();

        Iterator<Integer> iteratorA = dataArray.createIterator();
        Iterator<Integer> iteratorB = dataArrayList.createIterator();
        Iterator<Integer> iteratorC = dataMap.createIterator();

        System.out.println("-- 1 --");
        dataArray.internalIterator(OPERATION);

        System.out.println("-- 2 --");
        dataArrayList.internalIterator(OPERATION);

        System.out.println("-- 3 --");
        dataMap.internalIterator(OPERATION);

        System.out.println("-- 4 --");
        print(iteratorA);

        System.out.println("-- 5 --");
        print(iteratorB);

        System.out.println("-- 6 --");
        print(iteratorC);
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
