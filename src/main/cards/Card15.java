package main.cards;

import main.Player;
import main.Room;

public class Card15 extends Card{

    public Card15() {
        cardName = "Physics 151";
        location = "ECS 308";
        reward = "5 Quality Points";
        imagePath = "main/Cards/cardm15.png";
    }

    public void play(Player thisPlayer) {
        if ((thisPlayer.getRoom() == Room.ECS_308) && thisPlayer.getCraft() == 3) {
            thisPlayer.offsetQuality(5); //get 1 craft Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-3);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
