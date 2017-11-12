package main;

import main.Cards.Card;
import main.Cards.Card39;
import main.Cards.Decks;
import main.impl.DrawablePlayer;
import main.impl.PlayerImpl;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class PlayerController {
    //Offset required to prevent collision of tokens
    private static final int PLAYER_COUNT = 3;
    private static final int LABEL_OFFSET = 40;


    private final Player[] players;
    private static Decks decks;

    private int currentPlayer = 0;
    private final ControlPanel controlPanel;

    public PlayerController(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;

        decks = Decks.getInstance();

        players = new Player[PLAYER_COUNT];
        randomizePlayers(players);

    }

    public void setLabels(JLabel[] labels) {
        if (labels.length != players.length) {
            throw new InputMismatchException("Number of labels does not match the number of players");
        }
        for (int i = 0; i < labels.length; i++) {
            players[i] = new DrawablePlayer(players[i], labels[i], 10 + i * LABEL_OFFSET);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer + 1) % 3;
        if (currentPlayer != 0) {
            beginComputerTurn();
        } else {
            beginPlayerTurn();
        }
    }

    private void randomizePlayers(Player[] players)
    {
        final List<Integer> randomList = Arrays.asList(0, 1, 2);
        Collections.shuffle(randomList);
        players[randomList.get(0)] = new PlayerImpl("Jack", Room.ECS_308, 0, 0, 0, 0);
        players[randomList.get(1)] = new PlayerImpl("Lemon", Room.ECS_308, 0, 0, 0, 0);
        players[randomList.get(2)] = new PlayerImpl("Romulus", Room.ECS_308, 0, 0, 0, 0);

        for (Player player : players)
        {
            initialDraw(player);
        }
    }

    private void initialDraw(Player player) {
        player.draw();
    }


    private void beginComputerTurn() {
        controlPanel.setMoveEnabled(false);
        controlPanel.setRooms(new Room[0]);
        final Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Room[] adjacentRooms = getCurrentPlayer().getRoom().getAdjacentRooms();
                getCurrentPlayer().setRoom(adjacentRooms[ThreadLocalRandom.current().nextInt(adjacentRooms.length)]);
                nextTurn();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }


    private void beginPlayerTurn() {
        controlPanel.setMoveEnabled(true);
        controlPanel.setRooms(getCurrentPlayer().getRoom().getAdjacentRooms());
    }
}
