package com.github.mdssjc.beatboxpro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestRemoteReader {

  private static final boolean[] EMPTY_CHECKBOXES = new boolean[256];
  private static final String TEST_JPEG_FILENAME = "";

  private BeatBox beatBox;

  @Before
  public void setUp() throws IOException {
    this.beatBox = new BeatBox();
    this.beatBox.startUp("");
  }

  @After
  public void tearDown() throws IOException {
  }

  @Test
  public void testNormalMessage() throws IOException {
    final boolean[] checkboxState = new boolean[256];
    checkboxState[0] = true;
    checkboxState[5] = true;
    checkboxState[19] = true;

    this.beatBox.out.writeObject("This is a test message!");
    this.beatBox.out.writeObject(checkboxState);
  }

  @Test
  public void testPictureMessage() throws IOException {
    this.beatBox.out.writeObject(Messages.PICTURE_START_SEQUENCE.name());
    this.beatBox.out.writeObject(EMPTY_CHECKBOXES);
    sendJPEG(TEST_JPEG_FILENAME);
  }

  @Test
  public void testPoke() throws IOException {
    this.beatBox.out.writeObject(Messages.POKE_START_SEQUENCE.name());
    this.beatBox.out.writeObject(EMPTY_CHECKBOXES);
  }

  private void sendJPEG(final String filename) {
  }
}
