/*
 * Design Pattern
 * Behavioral - Template Method
 *
 */
package base;

import application.ApplicationClassA;
import application.ApplicationClassB;

public class Main {

    public static void main(String[] args) {
        ApplicationClassA appA = new ApplicationClassA();
        ApplicationClassB appB = new ApplicationClassB();

        appA.templateMethod();
        appB.templateMethod();
    }
}
