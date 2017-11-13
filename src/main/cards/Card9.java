package main.cards;

import main.Player;
import main.Room;
import main.CardDialog;

public class Card9 extends Card {

    static String oneUp = "learning";

    Card9(){
        cardName = "Parking Violation";
        location = "Forbidden Parking";
        reward = "1 Knowledge Token and/or Discarded 1 game card for 1 Knowledge Token";
        imagePath = "main/Cards/cardm09.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom()==Room.FORBIDDEN_PARKING) {
            processChipDialog( thisPlayer, oneUp);   //get 1 learning chip
            //if(thisPlayer.isUser())
            //{
             //   int alert = JOptionPane.showConfirmDialog(null,"Trade 1 game card for 1 knolege token", "Choose", 0); //tells the player if they would like to trade 1 card for 1 knowledge chip
             //   if (alert==0)
             //   {
                    thisPlayer.discardCard(new CardDialog().display(thisPlayer, this));
                    processChipDialog( thisPlayer, oneUp);
             //   }
            //}
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }

}
