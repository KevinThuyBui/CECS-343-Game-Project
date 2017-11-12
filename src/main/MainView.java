package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainView extends JFrame {

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private final ControlPanel controlPanel;
    private final PlayerController playerState;

    /**
     * Create the frame.
     */
    private MainView() {
        //Create the Jpanel for the entire application
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1244, 1000);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //Create a PlayerController to store player positions
        controlPanel = new ControlPanel();
        playerState = new PlayerController(controlPanel);

        //Create a MapScrollPane for game map
        MapScrollPane map = new MapScrollPane();
        map.initializePlayerTokens(playerState);

        getContentPane().add(map, BorderLayout.CENTER);

        //Create a panel to hold the player information and interactions below
        controlPanel.setRooms(playerState.getCurrentPlayer().getRoom().getAdjacentRooms());
        controlPanel.addMoveListener(new MoveListener());
        getContentPane().add(controlPanel, BorderLayout.SOUTH);


    }

    private class MoveListener implements RoomMoveListener {

        @Override
        public void onMove(Room room) {
            playerState.getCurrentPlayer().setRoom(room);
            playerState.nextTurn();

        }
    }

}
