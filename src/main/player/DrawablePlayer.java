package main.player;

import main.Room;
import main.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawablePlayer extends PlayerDecorator {

    private final JLabel label;
    private final int labelOffset;

    public DrawablePlayer(Player player, JLabel label, int labelOffset) {
        super(player);
        this.label = label;
        this.labelOffset = labelOffset;
        setRoom(player.getRoom());
    }

    @Override
    public void setRoom(Room currentRoom) {
        player.setRoom(currentRoom);
        final Point begin = label.getLocation();
        final Point end = currentRoom.getDrawPosition();
        final double dx = (end.getX() - begin.getX()) / 100;
        final double dy = (end.getY() + labelOffset - begin.getY()) / 100;

        new Timer(10, new ActionListener() {
            double x = begin.x;
            double y = begin.y;
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setLocation((int) (x += dx), (int) (y += dy));
                counter++;
                if (counter == 100) {
                    ((Timer) e.getSource()).stop();
                }
            }
        }).start();
    }

    @Override
    public Card chooseDiscard() {
        return player.chooseDiscard();
    }

    @Override
    public String chooseChip(boolean learning, boolean craft, boolean integrity) {
        return player.chooseChip(learning, craft, integrity);
    }
}
