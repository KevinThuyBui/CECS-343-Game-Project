package main;

import main.Cards.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CardButton extends JToggleButton{
    private Card inputCard;
    public CardButton(Card inputCard) {
        super();
        this.inputCard = inputCard;
        Image cardImage = getCardImage();
        setIcon(new ImageIcon(cardImage));
    }

    private Image getCardImage()
    {
        Image img = null;
       try
       {
           img = ImageIO.read(getClass().getClassLoader().getResource(inputCard.getFilePath()));
       } catch (IOException e) {
           e.printStackTrace();
       }
        return img;
    }

    public Card getCard()
    {
        return inputCard;
    }

}
