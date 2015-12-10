/*
 * Design Pattern
 * Creational - Factory
 * 
 */

package base;

import creator.ClassOneFactoryMethod;
import creator.ClassThreeFactoryMethod;
import creator.ClassTwoFactoryMethod;
import creator.FactoryMethod;
import product.ClassGeneral;

public class Main {
    public static void main(String[] args) {
        FactoryMethod factory1 = new ClassOneFactoryMethod();
        FactoryMethod factory2 = new ClassTwoFactoryMethod();
        FactoryMethod factory3 = new ClassThreeFactoryMethod();

        factory1.onSetName("Class One");
        ClassGeneral one = factory1.makeClass();
        factory2.onSetName("Class Two");
        ClassGeneral two = factory2.makeClass();
        factory3.onSetName("Class Three");
        ClassGeneral three = factory3.makeClass();

        one.print();
        two.print();
        three.print();
    }
}
