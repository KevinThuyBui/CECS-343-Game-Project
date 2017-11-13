package main.Cards;

import main.Player;
import main.Room;

public class Card29 extends Card {

    Card29() {
        filePath = "main/Cards/cardm29.png";
        reward = "5 Quality Points and a Card";
        cardName = "Soccer Goalie";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.GEORGE_ALLEN_FIELD
                && thisPlayer.getCraft() >= 3
                && thisPlayer.getLearning() >= 3)
        {
            thisPlayer.offsetQuality(5);
            thisPlayer.draw();
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.STUDENT_PARKING);
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
