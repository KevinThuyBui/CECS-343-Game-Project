package main.Cards;

import main.Player;
import main.Room;

public class Card20 extends Card {

    public Card20() {
        filePath = "main/Cards/cardm20.png";
        reward = "5 Quality Points";
        cardName = "Make the Dean's List";
    }

    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.NORTH_HALL
                || thisPlayer.getRoom() == Room.SOUTH_HALL
                && thisPlayer.getLearning() >= 6)
        {
            thisPlayer.offsetQuality(5);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.STUDENT_PARKING);
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
