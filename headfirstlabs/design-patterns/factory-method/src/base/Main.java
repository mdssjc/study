/*
 * Design Pattern
 * Creational - Factory Method
 * 
 */

package base;

import creator.ConcreteFactoryPA;
import creator.ConcreteFactoryPB;
import creator.FactoryMethod;
import product.Product;

public class Main {
    public static void main(String[] args) {
        FactoryMethod factory1 = new ConcreteFactoryPA();
        FactoryMethod factory2 = new ConcreteFactoryPB();

        Product pa = factory1.factoryMethod();
        Product pb = factory2.factoryMethod();

        System.out.println(pa);
        System.out.println(pb);
    }
}
