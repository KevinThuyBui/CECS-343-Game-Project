package main;

import main.cards.Card;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControlPanel extends JPanel {

    private final MovePanel movePanel;
    private final PlayerPanel playerPanel;
    private final CardPanel cardPanel;
    private final Player[] players;
    private RoomMoveListener listener;

    public ControlPanel(Player[] players) {
        this.players = players;
        setMinimumSize(new Dimension(200, 2000));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        movePanel = new MovePanel(this);
        playerPanel = new PlayerPanel();
        cardPanel = new CardPanel(players[0]);
        add(Box.createHorizontalStrut(5));
        add(movePanel);
        add(Box.createHorizontalStrut(5));
        add(cardPanel);
        add(Box.createHorizontalStrut(5));
        add(playerPanel);
        add(Box.createHorizontalStrut(5));
    }

    public void addMoveListener(RoomMoveListener onMove) {
        this.listener = onMove;
    }

    private void notifyMove(Room selectedRoom) {
        listener.onMove(selectedRoom);
    }

    public void setRooms(Room[] rooms) {
        movePanel.setRooms(rooms);
    }

    public void setMoveEnabled(boolean isEnabled) {
        movePanel.setMoveEnabled(isEnabled);
    }

    public void setDrawCardEnabled(boolean drawCardEnabled) {
        cardPanel.setDrawCardEnabled(drawCardEnabled);
    }

    private static class MovePanel extends JPanel implements ActionListener {

        private final JButton move;
        private final ControlPanel panel;
        private final JList<Room> list;

        MovePanel(ControlPanel panel) {
            this.panel = panel;
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            list = new JList<>();
            list.setDragEnabled(false);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setName("Rooms");
            list.setPrototypeCellValue(Room.CECS_CONFERENCE_ROOM);
            list.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            move = new JButton("Move");
            move.addActionListener(this);
            move.setAlignmentX(Component.RIGHT_ALIGNMENT);
            JPanel jPanel = new JPanel();
            jPanel.add(move);
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
            final Room selectedRoom = list.getSelectedValue();
            if (selectedRoom != null) panel.notifyMove(selectedRoom);
        }

        void setMoveEnabled(boolean isEnabled) {
            move.setEnabled(isEnabled);
        }
    }

    public static class PlayerPanel extends JPanel {
        PlayerPanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            JTextArea info = new JTextArea();
            info.setEditable(false);
            info.setFont(new Font("Courier New", Font.PLAIN, 14));
            info.setText("This is the player info panel");
            info.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            info.setRows(6);
            JTextArea console = new JTextArea();
            console.setEditable(false);
            console.setFont(new Font("Courier New", Font.PLAIN, 14));
            console.setText("This is the event panel");
            console.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            console.setRows(3);
            add(info);
            add(Box.createVerticalStrut(10));
            add(console);
        }
    }

    private static class CardPanel extends JPanel {

        private final JButton cardImage;

        private final Player player;
        private int cardIndex;

        CardPanel(Player user) {
            player = user;
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            cardImage = new JButton();
            cardImage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    offsetCardIndex(1);
                }
            });

            add(cardImage);
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
                cardImage.setIcon(new ImageIcon(Card.getImageURL(card)));
            } else {
                cardImage.setIcon(null);
            }
        }

        public void setDrawCardEnabled(boolean drawCardEnabled) {

        }
    }
}
