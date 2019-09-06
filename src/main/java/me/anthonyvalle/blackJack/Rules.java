package me.anthonyvalle.blackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Rules {

    private Player player;


    //Dealer Rules Methods

    public boolean checkValue(Player player){
        /*
        The first section helps the player set the value of any Ace cards they might have.
         */
        Scanner input = new Scanner(System.in);
        boolean play = true;
        ArrayList<Cards> temp = new ArrayList<Cards>();
        temp=player.getCurrentHand();
        for (Cards c: temp){
            if (c.isAce()&&c.getValue()==0){//Confirms that card is a Ace and user has not already assigned a value
                System.out.println("What value do you want for your Ace");
                input.nextInt();

                player.getCurrentHandValue()+
            }
            else{}
        }
        if (player.getCurrentHandValue()>21){
            System.out.println("You Lost");
             return play=false;
        }
        return play;
    }
    public

}
