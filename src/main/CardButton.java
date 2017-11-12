package main;

import main.Cards.Card;

import javax.swing.*;

public class CardButton extends JButton {
    private Card inputCard;
    public CardButton(Card inputCard) {
        this.inputCard = inputCard;
        Icon cardIcon = getCardImage();
        setIcon(cardIcon);
    }

    private Icon getCardImage()
    {
        final ImageIcon cardIcon;
        cardIcon = new ImageIcon(inputCard.getFilePath());

        return cardIcon;
    }

    public Card getCard()
    {
        return inputCard;
    }

}
