/*
 * Design Pattern
 * Behavioral - Iterator (Cursor)
 *
 */
package base;

import java.util.Iterator;

import data.ArrayListStructure;
import data.ArrayStructure;
import data.DataIterator;

public class Main {

    public static void main(String[] args) {
        DataIterator dataArray = new ArrayStructure();
        DataIterator dataArrayList = new ArrayListStructure();

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
