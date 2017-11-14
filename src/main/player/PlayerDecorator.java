package main.player;

import main.Room;
import main.cards.Card;

import java.awt.*;
import java.util.List;

public abstract class PlayerDecorator implements Player {

    protected final Player player;

    public PlayerDecorator(Player player) {
        this.player = player;
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
    public int getIntegrity() {
        return player.getIntegrity();
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
    }

    @Override
    public List<Card> getHand() {
        return player.getHand();
    }

    @Override
    public void drawCard() {
        player.drawCard();
    }

    @Override
    public void discardCard(Card display) {
        player.discardCard(display);
    }

    @Override
    public String toString() {
        return player.toString();
    }
}
