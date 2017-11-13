package main.Cards;

import main.Player;
import main.Room;
import main.CardDialog;

public class Card14 extends Card {

    public Card14(){
        cardName = "Math 123";
        location = "ECS 302 and 308";
        reward = "5 Quality Points";
        filePath = "main/Cards/cardm14.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if ((thisPlayer.getRoom()== Room.ECS_302 || thisPlayer.getRoom() == Room.ECS_308) && thisPlayer.getLearning() == 5) {
            thisPlayer.offsetQuality(5); //get 1 craft Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-3);
            thisPlayer.discardCard(new CardDialog().display(thisPlayer));
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}