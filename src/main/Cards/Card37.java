package main.Cards;

import main.Player;
import main.Room;

public class Card37 extends Card {
    public Card37 ()
    {
        filePath = "main/Cards/cardm37.png";
        reward = "1 Craft Chip";
    }

    @Override
    void play(Player thisPlayer) {
        if (outsideECS(thisPlayer.getRoom()))
        {
            thisPlayer.offsetCraft(1);
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }

    private boolean outsideECS(Room room)
    {
        switch (room){
            case ECS_308:
            case SOUTH_HALL:
            case EAT_CLUB:
            case CECS_CONFERENCE_ROOM:
            case ELEVATORS:
            case NORTH_HALL:
            case LACTATION_LOUNGE:
            case ROOM_OF_RETIREMENT:
            case COMPUTER_LAB:
            case ECS_302:
                return false;

            default:
                return true;
        }

    }
}
