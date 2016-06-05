/*
 * Design Pattern
 * Structural - Facade
 *
 */
package base;

import facade.Facade;

public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.message1();
        facade.message2();
        facade.message3();
    }
}
