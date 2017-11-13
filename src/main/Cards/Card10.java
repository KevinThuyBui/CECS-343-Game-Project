package main.Cards;

import main.Player;
import main.Room;

public class Card10 extends Card {

    static String oneUp = "learning";

    public Card10(){
            cardName = "CECS 105";
            location = "CECS 302 or CECS 308";
            reward = "1 Learning Chip";
            filePath = "main/Cards/cardm10.png";
        }


        @Override
        public void play(Player thisPlayer) {
            if (thisPlayer.getRoom()== Room.ECS_302 | thisPlayer.getRoom() == Room.ECS_308) {
                processChipDisplay( thisPlayer, oneUp);                                 //get 1 learning Chip
                outcome = successfulOutcomeString(thisPlayer.getName());
            }
            else
            {
                outcome = failedOutcomeString(thisPlayer.getName());
            }
        }
    }
