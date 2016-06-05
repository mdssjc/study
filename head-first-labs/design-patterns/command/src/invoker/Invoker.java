package invoker;

import command.Command;
import command.NullObjectCommand;

public class Invoker {

    private Command command;

    public Invoker() {
        this.command = new NullObjectCommand();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void play() {
        this.command.execute();
    }

    public void reverse() {
        this.command.undo();
    }
}
