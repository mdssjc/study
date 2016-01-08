/*
 * Design Pattern
 * Behavioral - Iterator (Cursor)
 *
 */
package base;

import java.util.Iterator;

import data.ArrayListStructure;
import data.ArrayStructure;

public class Main {

    public static void main(String[] args) {
        ArrayStructure array = new ArrayStructure();
        ArrayListStructure list = new ArrayListStructure();

        Iterator<Integer> iteratorA = array.createIterator();
        Iterator<Integer> iteratorB = list.createIterator();

        print(iteratorA);
        print(iteratorB);
    }

    private static void print(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
