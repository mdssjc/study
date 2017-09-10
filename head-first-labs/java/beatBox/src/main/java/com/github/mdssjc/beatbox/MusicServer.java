package com.github.mdssjc.beatbox;

import com.github.mdssjc.beatbox.events.ClientHandler;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MusicServer {

  private List<ObjectOutputStream> clientOutputStreams;

  public static void main(final String[] args) {
    new MusicServer().go();
  }

  public void go() {
    this.clientOutputStreams = new ArrayList<>();

    try {
      final ServerSocket serverSock = new ServerSocket(4242);
      while (true) {
        final Socket clientSocket = serverSock.accept();
        final ObjectOutputStream out = new ObjectOutputStream(
            clientSocket.getOutputStream());
        this.clientOutputStreams.add(out);
        final Thread t = new Thread(new ClientHandler(this, clientSocket));
        t.start();
        System.out.println("got a connection");
      }
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }

  public void tellEveryone(final Object one, final Object two) {
    for (final ObjectOutputStream out : this.clientOutputStreams) {
      try {
        out.writeObject(one);
        out.writeObject(two);
      } catch (final Exception ex) {
        Logger.getGlobal()
              .severe(ex.getMessage());
      }
    }
  }
}
