/*
 * Design Pattern
 * Creational - Abstract Method
 * 
 */

package base;

import creator.AbstractFactory;
import creator.ConcreteFactory1;
import creator.ConcreteFactory2;
import product.AbstractProductA;
import product.AbstractProductB;

public class Main {

    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();

        AbstractProductA a1 = factory1.createProductA();
        AbstractProductA a2 = factory2.createProductA();

        AbstractProductB b1 = factory1.createProductB();
        AbstractProductB b2 = factory2.createProductB();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);
    }
}
