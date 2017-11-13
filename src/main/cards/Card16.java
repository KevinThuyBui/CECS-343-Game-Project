package main.cards;

import main.Player;
import main.Room;

public class Card16 extends Card{

    public Card16() {
        cardName = "KIN 253 Learning the Rules of Soccer";
        location = "George Allen Field";
        reward = "2 craft Chips";
        imagePath = "main/Cards/cardm16.png";
    }
    public void play(Player thisPlayer) {
        if ((thisPlayer.getRoom() == Room.GEORGE_ALLEN_FIELD) && thisPlayer.getIntegrety() == 4) {
            thisPlayer.offsetCraft(2); //get 1 craft Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.ROOM_OF_RETIREMENT); //sets player Room
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
