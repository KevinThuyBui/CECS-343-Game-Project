package main;

import main.cards.Card;
import main.player.ComputerPlayer;
import main.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CardDialog extends JDialog {
    private JPanel buttonPanel;
    private Card selectedCard;

    public CardDialog()
    {
        setModal(true);
        JPanel root = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        buttonPanel = new JPanel();
        scrollPane.setViewportView(buttonPanel);

        root.setPreferredSize(new Dimension(1000, 350));
        scrollPane.setPreferredSize(new Dimension(1000, 308));
        scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        JButton ok = new JButton("OK");
        ok.addActionListener(e -> dispose());

        root.add(scrollPane, BorderLayout.NORTH);
        root.add(ok, BorderLayout.SOUTH);
        getContentPane().add(root);

        setTitle("Pick a card to discard");
    }


    public Card display(Player user, Card playedCard)
    {
        ButtonGroup cardSelection = new ButtonGroup();
        for (Card card : user.getHand())
        {
            if (card != playedCard) {
                CardButton cardButton = new CardButton(card);
                buttonPanel.add(cardButton);
                cardSelection.add(cardButton);
                cardButton.addActionListener(new CardActionListener());
            }
        }

        pack();
        setVisible(true);

        return selectedCard;
    }


    public Card display(Player user)
    {
        if (user instanceof ComputerPlayer)
        {
            return user.getHand().get(0);
        }
        else {
            ButtonGroup cardSelection = new ButtonGroup();
            for (Card card : user.getHand()) {
                CardButton cardButton = new CardButton(card);
                buttonPanel.add(cardButton);
                cardSelection.add(cardButton);
                cardButton.addActionListener(new CardActionListener());
            }

            pack();
            setVisible(true);

            return selectedCard;
        }
    }


    private class CardActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardButton pressedButton = (CardButton) e.getSource();
            selectedCard = pressedButton.getCard();
        }
    }

    public static class CardButton extends JToggleButton{
        private Card inputCard;
        public CardButton(Card inputCard) {
            super();
            this.inputCard = inputCard;
            BufferedImage read;
            try {
                read = ImageIO.read(Card.getImageURL(inputCard));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            BufferedImage unpressed = new BufferedImage(read.getWidth(), read.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D graphics = unpressed.createGraphics();
            graphics.drawImage(read, 0, 0, null);
            graphics.dispose();
            setIcon(new ImageIcon(unpressed));
            ImageIcon pressedIcon = new ImageIcon(Card.getImageURL(inputCard));
            setSelectedIcon(pressedIcon);
            setPressedIcon(pressedIcon);
        }


        public Card getCard()
        {
            return inputCard;
        }

    }
}
