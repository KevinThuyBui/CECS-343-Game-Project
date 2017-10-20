package main.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Provided by <b>MadProgrammer</b> at <a href="https://stackoverflow.com/a/31173371">stack overflow</a>.
 */
public class ScrollPaneMouseDragAdapter extends MouseAdapter {

    private Point origin;
    private JComponent map;

    public ScrollPaneMouseDragAdapter(JComponent map) {
        this.map = map;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        origin = new Point(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        origin = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (origin != null) {
            JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, map);
            if (viewPort != null) {
                int deltaX = origin.x - e.getX();
                int deltaY = origin.y - e.getY();

                Rectangle view = viewPort.getViewRect();
                view.x += deltaX;
                view.y += deltaY;

                map.scrollRectToVisible(view);
            }
        }
    }

}
