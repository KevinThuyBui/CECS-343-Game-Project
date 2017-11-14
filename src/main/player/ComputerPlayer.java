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
package main.player;

import main.cards.Card;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends PlayerDecorator {
    public ComputerPlayer(Player player) {
        super(player);
    }

    @Override
    public Card chooseDiscard() {
        List<Card> hand = getHand();
        Card card = hand.get(ThreadLocalRandom.current().nextInt(hand.size()));
        discardCard(card);
        return card;
    }

    @Override
    public String chooseChip(boolean learning, boolean craft, boolean integrity) {
        String result = null;
        while (result == null) {
            int select = ThreadLocalRandom.current().nextInt(3);
            switch (select) {
                case 0:
                    if (learning) {
                        result = "Learning";
                        offsetLearning(1);
                    }
                    break;
                case 1:
                    if (craft) {
                        result = "Craft";
                        offsetCraft(1);
                    }
                    break;
                case 2:
                    if (integrity) {
                        result = "Integrity";
                        offsetIntegrity(1);
                    }
                    break;
            }
        }
        return result;
    }
}
