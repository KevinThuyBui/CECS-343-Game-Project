package main;

import main.Cards.Card;
import main.impl.PlayerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    public Card display(Player user)
    {
        ButtonGroup cardSelection = new ButtonGroup();
        for (Card card : user.getUserHand())
        {
            CardButton cardButton = new CardButton(card);
            buttonPanel.add(cardButton);
            cardSelection.add(cardButton);
            cardButton.addActionListener(new CardActionListener());

        }


        pack();
        setVisible(true);

        return selectedCard;
    }


    private class CardActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardButton pressedButton = (CardButton) e.getSource();
            selectedCard = pressedButton.getCard();
        }
    }
}
