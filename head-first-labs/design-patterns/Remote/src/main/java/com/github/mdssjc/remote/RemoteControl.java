package com.github.mdssjc.remote;

public class RemoteControl {

  private final Command[] onCommands;
  private final Command[] offCommands;
  private Command undoCommand;

  public RemoteControl() {
    this.onCommands = new Command[7];
    this.offCommands = new Command[7];

    final Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      this.onCommands[i] = noCommand;
      this.offCommands[i] = noCommand;
    }
    this.undoCommand = noCommand;
  }

  public void setCommand(final int slot, final Command onCommand, final Command offCommand) {
    this.onCommands[slot] = onCommand;
    this.offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(final int slot) {
    this.onCommands[slot].execute();
    this.undoCommand = this.onCommands[slot];
  }

  public void offButtonWasPushed(final int slot) {
    this.offCommands[slot].execute();
    this.undoCommand = this.offCommands[slot];
  }

  public void undoButtonWasPushed() {
    this.undoCommand.undo();
  }

  @Override
  public String toString() {
    final StringBuffer stringBuff = new StringBuffer();
    stringBuff.append("\n------ Remote Control -------\n");
    for (int i = 0; i < this.onCommands.length; i++) {
      stringBuff.append("[slot " + i + "] " +
                        this.onCommands[i].getClass()
                                          .getName() + " " +
                        this.offCommands[i].getClass()
                                           .getName() + "\n");
    }
    return stringBuff.toString();
  }
}
