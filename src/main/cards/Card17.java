package main.cards;

import main.Player;
import main.Room;

public class Card17 extends Card{

    public Card17(){
        cardName = "Learning Netbeans";
        location = "ECS 302 and 308";
        reward = "5 Quality Points";
        imagePath = "main/Cards/cardm17.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if ((thisPlayer.getRoom()== Room.LACTATION_LOUNGE) && thisPlayer.getLearning() == 3) {
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
