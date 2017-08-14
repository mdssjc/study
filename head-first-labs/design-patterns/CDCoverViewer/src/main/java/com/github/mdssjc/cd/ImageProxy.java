package com.github.mdssjc.cd;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.logging.Logger;

public class ImageProxy implements Icon {

  private final URL imageURL;
  private ImageIcon imageIcon;
  private Thread retrievalThread;
  private boolean retrieving;

  public ImageProxy(final URL url) {
    this.imageURL = url;
  }

  public int getIconWidth() {
    if (this.imageIcon != null) {
      return this.imageIcon.getIconWidth();
    }
    return 800;
  }

  public int getIconHeight() {
    if (this.imageIcon != null) {
      return this.imageIcon.getIconHeight();
    }
    return 600;
  }

  public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
    if (this.imageIcon != null) {
      this.imageIcon.paintIcon(c, g, x, y);
    } else {
      g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
      if (!this.retrieving) {
        this.retrieving = true;
        this.retrievalThread = new Thread(() -> {
          try {
            this.imageIcon = new ImageIcon(this.imageURL, "CD Cover");
            c.repaint();
          } catch (final Exception e) {
            Logger.getGlobal()
                  .info(e.getMessage());
          }
        });
        this.retrievalThread.start();
      }
    }
  }
}
