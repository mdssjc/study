/*
 * Design Pattern
 * Structural - Adapter (Wrapper)
 * 
 */
package base;

import adaptee.Adaptee;
import adapter.Adapter;
import adapter.Target;

public class Main {

    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
