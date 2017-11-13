package main.Cards;

import main.Player;
import main.Room;

public class Card30 extends Card {
    Card30()
    {
        filePath = "main/Cards/cardm30.png";
        reward = "1 Learning Chip and 1 Card";
        cardName = "Elective Class";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.LIBRARY)
        {
            thisPlayer.offsetLearning(1);
            thisPlayer.draw();
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-2);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
