package com.threechat.view.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
//from  w w w. j  a  va  2 s  .c  o m
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Main {
  public static void main(String[] args) {
    JTextArea cmp = new JTextArea();
    String str = "a";
    for (int i = 0; i < 20; i++) {
      cmp.append(str + str + "\n");
    }
    JScrollPane scrollPane = new JScrollPane(cmp);
    scrollPane.setComponentZOrder(scrollPane.getVerticalScrollBar(), 0);
    scrollPane.setComponentZOrder(scrollPane.getViewport(), 1);
    scrollPane.getVerticalScrollBar().setOpaque(false);

    scrollPane.setLayout(new ScrollPaneLayout() {
      @Override
      public void layoutContainer(Container parent) {
        JScrollPane scrollPane = (JScrollPane) parent;

        Rectangle availR = scrollPane.getBounds();
        availR.x = availR.y = 0;

        Insets parentInsets = parent.getInsets();
        availR.x = parentInsets.left;
        availR.y = parentInsets.top;
        availR.width -= parentInsets.left + parentInsets.right;
        availR.height -= parentInsets.top + parentInsets.bottom;

        Rectangle vsbR = new Rectangle();
        vsbR.width = 12;
        vsbR.height = availR.height;
        vsbR.x = availR.x + availR.width - vsbR.width;
        vsbR.y = availR.y;

        if (viewport != null) {
          viewport.setBounds(availR);
        }
        if (vsb != null) {
          vsb.setVisible(true);
          vsb.setBounds(vsbR);
        }
      }
    });
    scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
    
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(scrollPane);
    f.setSize(320, 240);
    f.setVisible(true);
  }
}

class MyScrollBarUI extends BasicScrollBarUI {
  private final Dimension d = new Dimension();

  @Override
  protected JButton createDecreaseButton(int orientation) {
    return new JButton() {
      @Override
      public Dimension getPreferredSize() {
        return d;
      }
    };
  }

  @Override
  protected JButton createIncreaseButton(int orientation) {
    return new JButton() {
      @Override
      public Dimension getPreferredSize() {
        return d;
      }
    };
  }

  @Override
  protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
  }

  @Override
  protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    Color color = null;
    JScrollBar sb = (JScrollBar) c;
    if (!sb.isEnabled() || r.width > r.height) {
      return;
    } else if (isDragging) {
      color = Color.DARK_GRAY;
    } else if (isThumbRollover()) {
      color = Color.LIGHT_GRAY;
    } else {
      color = Color.GRAY;
    }
    g2.setPaint(color);
    g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
    g2.setPaint(Color.WHITE);
    g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
    g2.dispose();
  }

  @Override
  protected void setThumbBounds(int x, int y, int width, int height) {
    super.setThumbBounds(x, y, width, height);
    scrollbar.repaint();
  }
}
