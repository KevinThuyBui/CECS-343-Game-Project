package main;

import javax.swing.*;

public class CardButton extends JButton {
    public CardButton(Card inputCard) {
        Icon cardIcon = getCardImage(inputCard);
        setIcon(cardIcon);
    }

    private Icon getCardImage(Card inputCard)
    {
        final ImageIcon cardIcon;
        cardIcon = new ImageIcon(inputCard.getImagePath());

        return cardIcon;
    }

}
