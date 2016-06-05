/*
 * Design Pattern
 * Structural - Decorator (Wrapper)
 * 
 */

package base;

import component.Component;
import component.ConcreteComponent;
import decorator.Decorator;
import decorator.Decorator2;

public class Main {

    public static void main(String[] args) {
        Component counter = new ConcreteComponent();

        System.out.println(counter.text());
        counter.inc();
        counter.inc();
        counter.inc();
        System.out.println(counter.text());

        counter = new Decorator(counter);
        counter.inc();
        System.out.println(counter.text());
        counter = new Decorator2(counter);
        System.out.println(counter.text());
    }
}
