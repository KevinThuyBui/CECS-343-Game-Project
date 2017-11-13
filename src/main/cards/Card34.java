package main.cards;

import main.Player;
import main.Room;

public class Card34 extends Card {
    Card34()
    {
        cardName = "Chem 111";
        imagePath = "main/Cards/cardm34.png";
        reward = "5 Quality Points";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().outsideECS()
                && thisPlayer.getRoom().isABuilding()
                && thisPlayer.getCraft() >= 6)
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
