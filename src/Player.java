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

public class Player {

    private Room currentRoom;

    //private int numOfAdjacentRooms;

    public int integrety;
    public int craft;
    public int learning;
    public int quality;

    public Player(Room currentRoom, int integrety, int craft, int learning, int quality) {
        this.currentRoom = currentRoom;
        this.integrety = integrety;
        this.craft = craft;
        this.learning = learning;
        this.quality = quality;
    }

    //set player to room attributes
    public Point getPoint()
    {
        return currentRoom.getDrawPosition();
    }

    public int getIntegrety() {
        return integrety;
    }

    public int getCraft() {
        return craft;
    }

    public int getLearning() {
        return learning;
    }

    public int getQuality() {
        return quality;
    }

    public void offsetLearning(int value) {
        learning += value;
    }
    public void offsetCraft(int value) {
        craft += value;
    }
    public void offsetIntegrity(int value) {
        integrety += value;
    }
    public void offsetQuality(int value) {
        quality += value;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}

