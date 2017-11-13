package main;

import javax.swing.*;
import java.awt.event.*;

public class ChipDialog extends JDialog {
    private JPanel contentPane;
    private JButton learningButton;
    private JButton integrityButton;
    private JButton craftButton;
    private String buttonPressed;

    public ChipDialog() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Choose which attribute to increase");

        ChipButtonListener listener = new ChipButtonListener();

        learningButton.addActionListener(listener);
        integrityButton.addActionListener(listener);
        craftButton.addActionListener(listener);
    }

    private class ChipButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPressed = e.getActionCommand();
            dispose();
        }
    }

    public String showDialog(boolean learningButtonOn, boolean craftButtonOn, boolean integrityButtonOn)
    {
        learningButton.setEnabled(learningButtonOn);
        craftButton.setEnabled(craftButtonOn);
        integrityButton.setEnabled(integrityButtonOn);
        setVisible(true);

        return buttonPressed;
    }
}
