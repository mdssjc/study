/*
 * Design Pattern
 * Behavioral - Iterator (Cursor)
 *
 */
package base;

import java.util.Iterator;

import aggregate.ArrayListStructure;
import aggregate.ArrayStructure;
import aggregate.AggregateIterator;

public class Main {

    public static void main(String[] args) {
        AggregateIterator dataArray = new ArrayStructure();
        AggregateIterator dataArrayList = new ArrayListStructure();

        Iterator<Integer> iteratorA = dataArray.createIterator();
        Iterator<Integer> iteratorB = dataArrayList.createIterator();

        print(iteratorA);
        print(iteratorB);
    }

    private static void print(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
