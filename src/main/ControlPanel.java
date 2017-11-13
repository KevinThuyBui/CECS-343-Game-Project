package main;

import main.cards.Card;
import main.cards.Decks;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class ControlPanel extends JPanel {

    private final LeftPanel leftPanel;
    private final DisplayPanel displayPanel;
    private final CardPanel cardPanel;
    private final Player player;
    private final PlayerController controller;

    public ControlPanel(PlayerController controller) {
        this.controller = controller;
        this.player = controller.getPlayers()[0];
        setMinimumSize(new Dimension(200, 2000));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        leftPanel = new LeftPanel();
        displayPanel = new DisplayPanel();
        cardPanel = new CardPanel();
        add(Box.createHorizontalStrut(5));
        add(leftPanel);
        add(Box.createHorizontalStrut(5));
        add(cardPanel);
        add(Box.createHorizontalStrut(5));
        add(displayPanel);
        add(Box.createHorizontalStrut(5));
    }

    public void setRooms(Room[] rooms) {
        leftPanel.setRooms(rooms);
    }

    public void setMoveEnabled(boolean isEnabled) {
        leftPanel.setMoveEnabled(isEnabled);
    }

    public void setDrawCardEnabled(boolean isEnabled) {
        leftPanel.setDrawCardEnabled(isEnabled);
    }

    public void setPlayCardEnabled(boolean isEnabled) {
        leftPanel.setPlayCardEnabled(isEnabled);
    }

    public void setEndTurnEnabled(boolean isEnabled) {
        leftPanel.setEndTurnEnabled(isEnabled);
    }

    public void updateInfo() {
        displayPanel.updateInfo();
    }

    private class LeftPanel extends JPanel implements ActionListener {

        private final JButton move;
        private final JButton drawCard;
        private final JButton playCard;
        private final JButton endTurn;
        private final JList<Room> list;
        private int timesMoved;

        LeftPanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            list = new JList<>();
            list.setDragEnabled(false);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setName("Rooms");
            list.setPrototypeCellValue(Room.CECS_CONFERENCE_ROOM);
            list.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

            Insets margin = new Insets(3, 3, 3, 3);
            move = new JButton("Move");
            move.setMargin(margin);
            move.addActionListener(this);
            move.setEnabled(false);

            drawCard = new JButton("Draw Card");
            drawCard.setMargin(margin);
            drawCard.addActionListener(this);
            drawCard.setEnabled(false);

            playCard = new JButton("Play Card");
            playCard.setMargin(margin);
            playCard.addActionListener(this);
            playCard.setEnabled(false);

            endTurn = new JButton("End Turn");
            endTurn.setMargin(margin);
            endTurn.addActionListener(this);
            endTurn.setEnabled(false);

            JPanel jPanel = new JPanel();
            jPanel.setPreferredSize(new Dimension(155, 50));
            jPanel.setLayout(new GridLayout(2, 2, 3, 3));
            jPanel.add(drawCard);
            jPanel.add(playCard);
            jPanel.add(move);
            jPanel.add(endTurn);

            add(jPanel);
            add(Box.createVerticalGlue());
            list.setPreferredSize(new Dimension(150, 132));
            add(list);
        }

        void setRooms(Room[] rooms) {
            list.setListData(rooms);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Move":
                    final Room selectedRoom = list.getSelectedValue();
                    if (selectedRoom == null) break;
                    player.setRoom(selectedRoom);
                    timesMoved++;
                    if (timesMoved == 3)
                        setMoveEnabled(false);
                    setRooms(selectedRoom.getAdjacentRooms());
                    displayPanel.updateInfo();
                    break;
                case "Draw Card":
                    player.draw();
                    cardPanel.setCardIndex(0);
                    setDrawCardEnabled(false);
                    setMoveEnabled(true);
                    setPlayCardEnabled(true);
                    displayPanel.updateInfo();
                    break;
                case "Play Card":
                    Card card = player.getHand().get(cardPanel.cardIndex);
                    card.play(player);
                    setPlayCardEnabled(false);
                    setEndTurnEnabled(true);
                    displayPanel.updateInfo();
                    displayPanel.appendConsole(card.getOutcome());
                    cardPanel.setCardIndex(0);
                    break;
                case "End Turn":
                    setDrawCardEnabled(false);
                    setMoveEnabled(false);
                    setPlayCardEnabled(false);
                    setEndTurnEnabled(false);
                    while (player.getHand().size() > 7) {
                        player.discardCard(new CardDialog().display(player));
                    }
                    controller.nextTurn();
            }
        }

        private void setEndTurnEnabled(boolean isEnabled) {
            endTurn.setEnabled(isEnabled);
        }

        void setMoveEnabled(boolean isEnabled) {
            timesMoved = 0;
            move.setEnabled(isEnabled);
        }

        public void setDrawCardEnabled(boolean isEnabled) {
            drawCard.setEnabled(isEnabled);
        }

        public void setPlayCardEnabled(boolean isEnabled) {
            playCard.setEnabled(isEnabled);
        }
    }

    public class DisplayPanel extends JPanel {

        private final JTextArea info;
        private final JTextArea console;

        DisplayPanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            info = new JTextArea();
            info.setEditable(false);
            info.setFont(new Font("Courier New", Font.PLAIN, 14));
            info.setText("This is the player info panel");
            info.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            info.setRows(6);
            console = new JTextArea();
            console.setEditable(false);
            console.setFont(new Font("Courier New", Font.PLAIN, 14));
            console.setText("This is the event panel");
            console.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            console.setRows(3);
            add(info);
            add(Box.createVerticalStrut(10));
            add(console);
        }

        public void updateInfo() {
            Player player = controller.getCurrentPlayer();
            StringBuilder sb = new StringBuilder();
            sb.append("Cards in Hand:    ").append(ControlPanel.this.player.getHand().size()).append('\n');
            sb.append("Cards in Deck:    ").append(Decks.getInstance().drawCount()).append('\n');
            sb.append("Cards in Discard: ").append(Decks.getInstance().discardCount()).append("\n\n");
            sb.append(String.format("%-9s | %-9s %-8s %-8s | %-9s | %s%n", "Name", "Integrity", "  Craft", "Learning", " Quality", "Current Room"));
            for (Player p : controller.getPlayers()) {
                sb.append(String.format("%-9s | %5d     %5d   %5d     | %5d     | %s%n", p.getName(), p.getIntegrety(), p.getCraft(), p.getLearning(), p.getQuality(), p.getRoom()));
            }
            sb.append("\n");
            sb.append("TURN: ").append(player.getName()).append(" in ").append(player.getRoom());
            info.setText(sb.toString());
        }

        void appendConsole(String text) {
            if (console.getLineCount() == 3) {
                try {
                    console.replaceRange("", 0, console.getLineEndOffset(0));
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
            console.append("\n" + text);
        }
    }

    private class CardPanel extends JPanel {

        private final static int HAND_WIDTH = 155;
        private final static int HAND_HEIGHT = 220;

        private final JButton handCard;

        private int cardIndex;

        CardPanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            handCard = new JButton();
            handCard.setPreferredSize(new Dimension(HAND_WIDTH, HAND_HEIGHT));
            handCard.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    offsetCardIndex(1);
                }
            });
            add(handCard);
            setCardIndex(0);
        }

        public void setCardIndex(int cardIndex) {
            this.cardIndex = cardIndex;
            changeImage();
        }

        public void offsetCardIndex(int offset) {
            this.cardIndex += offset;
            changeImage();
        }

        private void changeImage() {
            List<Card> hand = player.getHand();
            if (!hand.isEmpty()) {
                if (cardIndex >= hand.size()) {
                    cardIndex %= hand.size();
                }
                Card card = hand.get(cardIndex);
                try {
                    BufferedImage read = ImageIO.read(Card.getImageURL(card));
                    Image scaled = read.getScaledInstance(HAND_WIDTH, HAND_HEIGHT, Image.SCALE_SMOOTH);
                    handCard.setIcon(new ImageIcon(scaled));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                handCard.setIcon(null);
            }
        }
    }
}
