package com.github.mdssjc.cd;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Logger;

public class ImageProxyTestDrive {

  private final JFrame frame = new JFrame("CD Cover Viewer");
  private final JMenuBar menuBar;
  private final JMenu menu;
  private final Hashtable cds = new Hashtable();
  private ImageComponent imageComponent;

  public ImageProxyTestDrive() throws Exception {
    this.cds.put("Ambient: Music for Airports",
                 "http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
    this.cds.put("Buddha Bar",
                 "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
    this.cds.put("Ima",
                 "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
    this.cds.put("Karma",
                 "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
    this.cds.put("MCMXC A.D.",
                 "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
    this.cds.put("Northern Exposure",
                 "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
    this.cds.put("Selected Ambient Works, Vol. 2",
                 "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");

    final URL initialURL = new URL(
        (String) this.cds.get("Selected Ambient Works, Vol. 2"));
    this.menuBar = new JMenuBar();
    this.menu = new JMenu("Favorite CDs");
    this.menuBar.add(this.menu);
    this.frame.setJMenuBar(this.menuBar);

    final Enumeration e = this.cds.keys();
    while (e.hasMoreElements()) {
      final String name = (String) e.nextElement();
      final JMenuItem menuItem = new JMenuItem(name);
      this.menu.add(menuItem);
      menuItem.addActionListener(event -> {
        this.imageComponent.setIcon(
            new ImageProxy(getCDUrl(event.getActionCommand())));
        this.frame.repaint();
      });
    }

    final Icon icon = new ImageProxy(initialURL);
    this.imageComponent = new ImageComponent(icon);
    this.frame.getContentPane()
              .add(this.imageComponent);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(800, 600);
    this.frame.setVisible(true);
  }

  public static void main(final String[] args) throws Exception {
    final ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
  }

  private URL getCDUrl(final String name) {
    try {
      return new URL((String) this.cds.get(name));
    } catch (final MalformedURLException e) {
      Logger.getGlobal()
            .info(e.getMessage());
      return null;
    }
  }
}
