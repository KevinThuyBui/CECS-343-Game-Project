/*    Copyright 2017 Ton Ly
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

    private final MovePanel movePanel;
    private final PlayerPanel playerPanel;
    private RoomMoveListener listener;

    public ControlPanel() {
        setLayout(new FlowLayout());
        movePanel = new MovePanel(this);
        add(movePanel);
        playerPanel = new PlayerPanel();
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


    public static class MovePanel extends JPanel {

        private ControlPanel panel;
        private JList<Room> list;

        private ComboBox<Room> roomComboBox;

        public MovePanel(ControlPanel panel) {
            this.panel = panel;
            setLayout(new GridLayout(2, 1, 10, 10));
            list = new JList<>();
            list.setDragEnabled(false);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setName("Rooms");
            final JButton move = new JButton("Move");
            move.addActionListener(this::onMove);
            add(move);
            add(list);
        }

        private void onMove(ActionEvent actionEvent) {
            final Room selectedRoom = roomComboBox.getSelectionModel().getSelectedItem();
            if (selectedRoom != null) panel.notifyMove(selectedRoom);
        }

        public void setRooms(Room[] rooms) {
            list.setListData(rooms);
        }
    }

    public static class PlayerPanel {
    }
}
