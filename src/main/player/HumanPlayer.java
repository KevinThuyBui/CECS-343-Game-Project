package main.player;

import main.CardDialog;
import main.ChipDialog;
import main.cards.Card;

public class HumanPlayer extends PlayerDecorator {

    public HumanPlayer(Player player) {
        super(player);
    }

    /**
     * Selects or prompts for a selection. Once a card has been selected, it is discarded from this player's hand.
     * @return the discarded card
     */
    @Override
    public Card chooseDiscard() {
        Card card = new CardDialog().display(this);
        discardCard(card);
        return card;
    }

    @Override
    public String chooseChip(boolean learning, boolean craft, boolean integrity) {
        String s = new ChipDialog().showDialog(learning, craft, integrity);
        incrementStat(s);
        return s;
    }

    private void incrementStat(String s) {
        switch (s.charAt(0)) {
            case 'C':
                offsetCraft(1);
                break;
            case 'I':
                offsetIntegrity(1);
                break;
            case 'L':
                offsetLearning(1);
                break;
        }
    }
}
