package main;

import main.impl.DrawablePlayer;
import main.impl.PlayerImpl;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;

class PlayerController {
    //Offset required to prevent collision of tokens
    private static final int PLAYER_COUNT = 3;
    private static final int LABEL_OFFSET = 40;


    private final Player[] players;

    private int currentPlayer = 0;
    private ControlPanel controlPanel;

    private ScheduledExecutorService service;

    public PlayerController(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;

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
        ArrayList<Integer> randomPlayerPositionList = createRandomList();

        players[randomPlayerPositionList.get(0)] = new PlayerImpl("Jack", Room.ECS_308, 0, 0, 0, 0);
        players[randomPlayerPositionList.get(1)] = new PlayerImpl("Lemon", Room.ECS_308, 0, 0, 0, 0);
        players[randomPlayerPositionList.get(2)] = new PlayerImpl("Romulus", Room.ECS_308, 0, 0, 0, 0);
    }

    private ArrayList<Integer> createRandomList()
    {
        ArrayList<Integer> randomPlayerPositionList = new ArrayList<>();
        randomPlayerPositionList.add(0);
        randomPlayerPositionList.add(1);
        randomPlayerPositionList.add(2);
        Collections.shuffle(randomPlayerPositionList);
        return randomPlayerPositionList;
    }


    private void beginComputerTurn() {
        controlPanel.setMoveEnabled(false);
        controlPanel.setRooms(new Room[0]);
        service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new Runnable() {
            @Override
            public void run() {
                Room[] adjacentRooms = getCurrentPlayer().getRoom().getAdjacentRooms();
                getCurrentPlayer().setRoom(adjacentRooms[ThreadLocalRandom.current().nextInt(adjacentRooms.length)]);
                nextTurn();
            }
        }, 1, TimeUnit.SECONDS);
    }


    private void beginPlayerTurn() {
        controlPanel.setMoveEnabled(true);
        controlPanel.setRooms(getCurrentPlayer().getRoom().getAdjacentRooms());
    }
}
