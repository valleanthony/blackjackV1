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
                int ace = input.nextInt();
                c.setValue(ace);

            }
            else{}
        }
        //Checks to see if player lost
        if (player.getCurrentHandValue()>21){
            System.out.println("You Lost");
            return play=false;
        }

        return play;
    }



    public boolean aceCard(Player dealer){
        boolean play = true;
        int holder =dealer.getCurrentHandValue();
        System.out.println("ACE METHOD::: CURRENT VALUE OF DEALER" + holder);
        if(dealer.isDealer()){ //Making sure this only used for the dealer
            ArrayList<Cards> temp = new ArrayList<Cards>();
            temp=dealer.getCurrentHand(); // holding current hand
            for (Cards b: temp){  //Checks each card to see if the dealer holds a Ace
                if (b.isAce()&& b.getValue()==0){ // if the dealer holds an Ace card the value is assigned based on the value of the other card the dealers holds
                    if (dealer.getCurrentHandValue()<=10){ // if the value of the other card is less thn 10 we assign 11 as the value of the ace
                        b.setValue(11);
                        dealer.setCurrentHandValue(holder+11);
                        System.out.println();
                    }
                    else if (dealer.getCurrentHandValue()>10){ //if the value of two cards is greater then ten then the value of Ace is one
                        b.setValue(1);
                        dealer.setCurrentHandValue(holder+1);
                    }
                }

            }
        }

        return play;

    }





}


