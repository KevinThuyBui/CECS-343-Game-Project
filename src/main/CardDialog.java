package main;

import main.impl.PlayerImpl;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JScrollPane cardScrollDisplay;
    private Player user;

    public CardDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

   public void display(PlayerImpl user)
   {
       for (main.Card card : user.getUserHand())
       {
           CardButton cardButton = new CardButton(card);
           cardScrollDisplay.add(cardButton);
       }
   }
}
