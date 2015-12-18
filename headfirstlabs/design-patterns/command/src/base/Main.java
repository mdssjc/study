/*
 * Design Pattern
 * Behavioral - Command (Action, Transaction)
 * 
 */
package base;

import command.Command;
import command.ConcreteCommand;
import invoker.Invoker;
import receiver.Receiver;

public class Main {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        Receiver receiver = new Receiver();

        Command command = new ConcreteCommand(receiver);

        invoker.setCommand(command);

        invoker.play();
        invoker.reverse();
    }
}
