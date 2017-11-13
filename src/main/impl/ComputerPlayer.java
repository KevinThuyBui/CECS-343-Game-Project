package main.impl;

import main.Player;

public class ComputerPlayer extends PlayerDecorator {

    public ComputerPlayer(Player player) {
        super(player);
    }
}
