package com.github.mdssjc.beatboxpro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestRemoteReader {

  public static final boolean[] EMPTY_CHECKBOXES = new boolean[256];
  private Socket mTestSocket;
  private ObjectOutputStream mOutStream;
  private ObjectInputStream mInStream;

  @Before
  public void setUp() throws IOException {
    this.mTestSocket = new Socket("127.0.0.1", 4242);
    this.mOutStream =
        new ObjectOutputStream(this.mTestSocket.getOutputStream());
    this.mInStream =
        new ObjectInputStream(this.mTestSocket.getInputStream());
  }

  @After
  public void tearDown() throws IOException {
    this.mTestSocket.close();
    this.mOutStream = null;
    this.mInStream = null;
    this.mTestSocket = null;
  }

  @Test
  public void testNormalMessage() throws IOException {
    final boolean[] checkboxState = new boolean[256];
    checkboxState[0] = true;
    checkboxState[5] = true;
    checkboxState[19] = true;
    this.mOutStream.writeObject("This is a test message!");
    this.mOutStream.writeObject(checkboxState);
  }
}
