package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.MusicServer;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {

  private final MusicServer server;
  private ObjectInputStream in;
  private Socket clientSocket;

  public ClientHandler(final MusicServer server, final Socket socket) {
    this.server = server;
    try {
      this.clientSocket = socket;
      this.in = new ObjectInputStream(this.clientSocket.getInputStream());
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }

  public void run() {
    Object o2;
    Object o1;
    try {
      while ((o1 = this.in.readObject()) != null) {
        o2 = this.in.readObject();
        System.out.println("read two objects");
        this.server.tellEveryone(o1, o2);
      }
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }
}
