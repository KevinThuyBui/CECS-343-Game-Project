package main.impl;

import main.Cards.Card;
import main.Player;
import main.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawablePlayer implements Player {
    private final Player player;
    private final JLabel label;
    private final int labelOffset;

    public DrawablePlayer(Player player, JLabel label, int labelOffset) {
        this.player = player;
        this.label = label;
        this.labelOffset = labelOffset;
        setRoom(player.getRoom());
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public Point getPoint() {
        return player.getPoint();
    }

    @Override
    public int getIntegrety() {
        return player.getIntegrety();
    }

    @Override
    public int getCraft() {
        return player.getCraft();
    }

    @Override
    public int getLearning() {
        return player.getLearning();
    }

    @Override
    public int getQuality() {
        return player.getQuality();
    }

    @Override
    public void offsetLearning(int value) {
        player.offsetLearning(value);
    }

    @Override
    public void offsetCraft(int value) {
        player.offsetCraft(value);
    }

    @Override
    public void offsetIntegrity(int value) {
        player.offsetIntegrity(value);
    }

    @Override
    public void offsetQuality(int value) {
        player.offsetQuality(value);
    }

    @Override
    public Room getRoom() {
        return player.getRoom();
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
    public ArrayList<Card> getUserHand() {
        return player.getUserHand();
    }

    @Override
    public void draw() {
        player.draw();
    }

    @Override
    public void discardCard(Card display) {
        player.discardCard(display);
    }
}
