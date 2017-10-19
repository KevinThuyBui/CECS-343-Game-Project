package main.impl;

import main.Player;
import main.Room;

import javax.swing.*;
import java.awt.*;

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
        Point drawPosition = currentRoom.getDrawPosition();
        label.setLocation(drawPosition.x, drawPosition.y + labelOffset);
    }
}
