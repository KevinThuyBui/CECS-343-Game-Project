package main.Cards;

import main.Player;
import main.Room;

public abstract class Card {
    String cardName;
    String location; //location where card is allowed to play
    String location1;
    String reward;
    String outcome;
    String filePath;

    public String getCardName()
    {
        return cardName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public abstract void play(Player thisPlayer);

    public String failedOutcomeString(String playerName)
    {
        return playerName + " failed to play " + cardName;
    }

    public String successfulOutcomeString(String playerName)
    {
        return playerName + " was awarded " + reward + " for playing " + cardName;
    }

    public String getOutcome()
    {
        return outcome;
    }

    void processChipDialog(Player player, String displayOutcome)
    {
        switch (displayOutcome) {
            case "integrity":
                player.offsetIntegrity(1);
                break;
            case "craft":
                player.offsetCraft(1);
                break;
            default:
                player.offsetLearning(1);
                break;
        }
    }


}
