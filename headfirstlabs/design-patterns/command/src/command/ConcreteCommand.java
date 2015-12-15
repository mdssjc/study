package command;

import receiver.Receiver;

public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.messageOne();
        receiver.messageTwo();
        receiver.messageThree();
    }
}
