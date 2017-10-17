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

import java.awt.*;
import java.util.EnumSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    private Room currentRoom;

    //private int numOfAdjacentRooms;

    public int integrety;
    public int craft;
    public int learning;
    public int quality;

    public Player()
    {
        currentRoom = new Room();
        //set attributes later
    }

    //get points
    public Point getPoint()
    {
        return currentRoom.getDrawPosition();
    }

    //added setPlayerToNewRoom
    public void setPlayerToNewRoom(String room)
    {
        currentRoom.setRoom(room);
    }

    //added
    public int getNumOfAdjecentRooms()
    {
        int numOfAdjacentRooms = currentRoom.getAdjacentRoomStrings().size();
        return numOfAdjacentRooms;
    }

    public void setToAnAjacentRoom(int whichroom)
    {
        setPlayerToNewRoom(currentRoom.getAdjacentRoomStrings().get(whichroom));
    }






	/*String ();

    int getLearning();
    int getCraft();
    int getIntegrity();
    int getQuality();

    void offsetLearning(int value);
    void offsetCraft(int value);
    void offsetIntegrity(int value);
    void offsetQuality(int values);

    Room getRoom();

    void setRoom(Room room);*/

}

/*public interface Player {

    public static Player newPlayer(String name, int a, int b, int c) {
        //todo
        return null;
    }

    String getNAme();

    int getLearning();
    int getCraft();
    int getIntegrity();
    int getQuality();

    void offsetLearning(int value);
    void offsetCraft(int value);
    void offsetIntegrity(int value);
    void offsetQuality(int values);

    Room getRoom();

    void setRoom(Room room);
}*/
