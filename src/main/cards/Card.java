package main.cards;

import main.Player;

import java.net.URL;

public abstract class Card {
    String cardName;
    String location; //location where card is allowed to play
    String location1;
    String reward;
    String outcome;
    String imagePath;

    public String getCardName()
    {
        return cardName;
    }

    public String getImagePath()
    {
        return imagePath;
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


    public static URL getImageURL(Card card) {
        return card.getClass().getResource(String.format("cardm%02d.png", Integer.parseInt(card.getClass().getSimpleName().substring(4))));
    }
}
