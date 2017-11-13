package main.impl;

import main.ChipDialog;
import main.Player;

public class HumanPlayer extends PlayerDecorator {

    public HumanPlayer(Player player) {
        super(player);
    }

    @Override
    public String chooseChip(boolean learning, boolean craft, boolean integrity) {
        String s = new ChipDialog().showDialog(learning, craft, integrity);
        incrementStat(s);
        return s;
    }

    private void incrementStat(String s) {
        switch (s.charAt(0)) {
            case 'C':
                offsetCraft(1);
                break;
            case 'I':
                offsetIntegrity(1);
                break;
            case 'L':
                offsetLearning(1);
                break;
        }
    }
}
