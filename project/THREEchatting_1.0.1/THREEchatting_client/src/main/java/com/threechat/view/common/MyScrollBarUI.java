package com.threechat.view.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollBarUI extends BasicScrollBarUI{

//	private Color trackColor =  Color.white;
//	
//	@Override
//    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
//        g.setColor(Color.red);
//        g.fillRect(trackBounds.x + trackBounds.width / 2, trackBounds.y, trackBounds.width / 2, trackBounds.height);
//
//        if(trackHighlight == DECREASE_HIGHLIGHT)        {
//            paintDecreaseHighlight(g);
//        }
//        else if(trackHighlight == INCREASE_HIGHLIGHT)           {
//            paintIncreaseHighlight(g);
//        }
//    }
//	
//	@Override
//	 protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
//    {
//        if(thumbBounds.isEmpty() || !scrollbar.isEnabled())     {
//            return;
//        }
//
//        int w = thumbBounds.width / 2;
//        int h = thumbBounds.height;
//
//        g.translate(thumbBounds.x, thumbBounds.y);
//
//        g.setColor(thumbDarkShadowColor);
//        g.drawRect(w, 0, w-1 , h-1);
//        g.setColor(thumbColor);
//        g.fillRect(w, 0, w-1, h-1);
//        //Image img = Toolkit.getDefaultToolkit().getImage("resource/images/scroll.jpg");
//        //g.drawImage(img, 0, 0, w-1, h-1, null);
//        g.setColor(thumbHighlightColor);
//        //g.drawLine(1, 1, 1, h-2);
//        //g.drawLine(2, 1, w-3, 1);
//
//        g.setColor(thumbLightShadowColor);
//       // g.drawLine(2, h-2, w-2, h-2);
//       // g.drawLine(w-2, 1, w-2, h-3);
//
//        g.translate(-thumbBounds.x, -thumbBounds.y);
//    }
//	
//	@Override
//	protected void installComponents(){
//        switch (scrollbar.getOrientation()) {
//        case JScrollBar.VERTICAL:
//            incrButton = createIncreaseButton(SOUTH);
//            decrButton = createDecreaseButton(NORTH);
//            break;
//
//        case JScrollBar.HORIZONTAL:
//            if (scrollbar.getComponentOrientation().isLeftToRight()) {
//                incrButton = createIncreaseButton(EAST);
//                decrButton = createDecreaseButton(WEST);
//            } else {
//                incrButton = createIncreaseButton(WEST);
//                decrButton = createDecreaseButton(EAST);
//            }
//            break;
//        }
////        scrollbar.add(incrButton);
////        scrollbar.add(decrButton);
//        // Force the children's enabled state to be updated.
//        scrollbar.setEnabled(scrollbar.isEnabled());
//    }
	
	
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
	  protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(new Color(237, 234, 232));
        g.fillRect(trackBounds.x + trackBounds.width / 2, trackBounds.y, trackBounds.width / 2, trackBounds.height);
        if(trackHighlight == DECREASE_HIGHLIGHT)        {
            paintDecreaseHighlight(g);
        }
        else if(trackHighlight == INCREASE_HIGHLIGHT)           {
            paintIncreaseHighlight(g);
        }
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
	    g2.fillRoundRect(r.x + r.width/2, r.y, r.width-8, r.height, 20, 20);
	    g2.setPaint(Color.WHITE);
	    g2.drawRoundRect(r.x + r.width/2, r.y, r.width-8, r.height, 20, 20);
	    g2.dispose();
	  }

	  @Override
	  protected void setThumbBounds(int x, int y, int width, int height) {
	    super.setThumbBounds(x, y, width, height);
	    scrollbar.repaint();
	  }
}
