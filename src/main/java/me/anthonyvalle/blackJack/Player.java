package me.anthonyvalle.blackJack;

import java.util.ArrayList;

public class Player {


    private int currentHandValue;
    private ArrayList<Cards> currentHand;
    private boolean dealer;

    public boolean isDealer() {
        return dealer;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    public int getCurrentHandValue() {
        return currentHandValue;
    }

    public void setCurrentHandValue(int currentHandValue) {
        this.currentHandValue = currentHandValue;
    }


    public ArrayList<Cards> getCurrentHand() {
        for (Cards c:currentHand){
            //System.out.println(c.toString());
        }

        //System.out.println(currentHandValue);
        return currentHand;
    }

    public void setCurrentHand(ArrayList<Cards> currentHand) {
        this.currentHand = currentHand;
    }
}
