package main.cards;

import main.Player;
import main.Room;

import java.net.URL;

public abstract class Card {
    private final String cardName;
    private final int reqIntegrity, reqCraft, reqLearning;

    protected String outcome;

    protected Card(String cardName, int reqIntegrity, int reqCraft, int reqLearning) {
        this.cardName = cardName;
        this.reqIntegrity = reqIntegrity;
        this.reqCraft = reqCraft;
        this.reqLearning = reqLearning;
    }

    public String getCardName() {
        return cardName;
    }

    public void useOn(Player player) {
        if (canPlay(player.getRoom())) {
            if (statisfiesRequirement(player)) {
                success(player);
            } else {
                penalty(player);
            }
        } else {
            player.offsetQuality(-2);
            setFailOutcome(player, "2 Quality Points.");
        }
        player.discardCard(this);
    }

    public boolean statisfiesRequirement(Player p) {
        return p.getIntegrity() >= reqIntegrity
                && p.getCraft() >= reqCraft
                && p.getLearning() >= reqLearning;
    }

    public abstract boolean canPlay(Room room);

    protected abstract void success(Player p);

    protected abstract void penalty(Player p);

    protected void setFailOutcome(Player p, String penalty) {
        outcome = p + " failed to play " + cardName + ", losing " + penalty;
    }

    protected void setSuccessOutcome(Player p, String reward) {
        outcome = p + " played " + cardName + "to gain " + reward;
    }

    protected void setSuccessOutcome(Player p, int i, String stat) {
        setSuccessOutcome(p, i + " " + stat + " Chip.");
    }

    public String getOutcome() {
        return outcome;
    }

    void processChipDialog(Player player, String displayOutcome) {
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

    @Override
    public String toString() {
        return cardName;
    }
}
