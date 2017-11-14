package main;

import main.cards.Card;
import main.player.*;

import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class PlayerController {
    //Offset required to prevent collision of tokens
    private static final int PLAYER_COUNT = 3;
    private static final int LABEL_OFFSET = 40;


    private final Player[] players;

    private int currentPlayer = -1;
    private ControlPanel controlPanel;

    PlayerController() {
        players = new Player[PLAYER_COUNT];
        randomizePlayers(players);
    }

    void setPlayerLabels(JLabel[] labels) {
        if (labels.length != players.length) {
            throw new InputMismatchException("Number of labels does not match the number of players");
        }

        for (int i = 0; i < labels.length; i++) {
            players[i] = new DrawablePlayer(players[i], labels[i], 10 + i * LABEL_OFFSET);
        }

        for (int i = 0; i < players.length; i++) {
            if (i == 0) {
                players[i] = new HumanPlayer(players[i]);
            } else {
                players[i] = new ComputerPlayer(players[i]);
            }

        }
    }

    Player[] getPlayers() {
        return players;
    }

    Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    void nextTurn() {
        currentPlayer = (currentPlayer + 1) % 3;
        controlPanel.updateInfo();
        if (currentPlayer != 0) {
            beginComputerTurn();
        } else {
            beginPlayerTurn();
        }
    }

    private void randomizePlayers(Player[] players) {
        final List<Integer> randomList = Arrays.asList(0, 1, 2);
        Collections.shuffle(randomList);
        players[randomList.get(0)] = new PlayerImpl("Jack", Room.ECS_308, 2, 2, 2, 0);
        players[randomList.get(1)] = new PlayerImpl("Lemon", Room.ECS_308, 3, 1, 2, 0);
        players[randomList.get(2)] = new PlayerImpl("Romulus", Room.ECS_308, 0, 3, 3, 0);

        for (Player player : players) {
            initialDraw(player);
        }
    }

    //Each player starts with 5 cards
    private void initialDraw(Player player) {
        for (int i = 0; i < 5; i++)
            player.drawCard();
    }


    private void beginComputerTurn() {
        controlPanel.setRooms(new Room[0]);
        Player computer = getCurrentPlayer();
        final Timer timer = new Timer(500, e -> {
            computer.drawCard();
            boolean playedCard = false;
            for (int i = 0; i < 3; i++) {
                if (!playedCard)
                    playedCard = playBestCard(computer);
                Room[] adjacentRooms = computer.getRoom().getAdjacentRooms();
                computer.setRoom(adjacentRooms[ThreadLocalRandom.current().nextInt(adjacentRooms.length)]);
            }
            if (!playedCard) {
                List<Card> hand = computer.getHand();
                Card card = hand.get(ThreadLocalRandom.current().nextInt(hand.size()));
                card.useOn(computer);
                controlPanel.getDisplayPanel().appendConsole(card.getOutcome());
            }
            nextTurn();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private boolean playBestCard(Player computer) {
        List<Card> hand = computer.getHand();
        for (Card card : hand) {
            if (card.canPlay(computer.getRoom()) && card.statisfiesRequirement(computer)) {
                card.useOn(computer);
                controlPanel.getDisplayPanel().appendConsole(card.getOutcome());
                return true;
            }
        }
        return false;
    }


    private void beginPlayerTurn() {
        controlPanel.setDrawCardEnabled(true);
        controlPanel.setRooms(getCurrentPlayer().getRoom().getAdjacentRooms());
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
}
