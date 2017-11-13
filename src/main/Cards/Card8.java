package main.Cards;

import main.Player;
import main.Room;
import main.ChipDialog;

public class Card8 extends Card {

    String oneUp;

    public Card8(){
        cardName = "Enjoying the Peace";
        location = "Japanese Gardens";
        reward = "1 Integrity Chip";
        filePath = "main/Cards/cardm08.png";
    }

    @Override
    public String getCardName() {
        return cardName;
    }

    @Override
    public void play(Player thisPlayer)
    {
        if(thisPlayer.getRoom() == Room.JAPANESE_GARDEN){       //played in the Library
            //if(thisPlayer.isUser()) {                        //ask player if this player is the user
                ChipDialog chip = new ChipDialog();//open a dialog ask player to choose a learning chip or integrity chip with an action listener
                oneUp = chip.showDialog(true, false, true);
                processChipDialog( thisPlayer, oneUp);
            //}
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else{
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }

}
