package me.anthonyvalle.blackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Rules {

    //Helper Functions

    public void checkValue(Player player){
        /*
        The first section helps the player set the value of any Ace cards they might have.
         */
        int pHolder =player.getCurrentHandValue();
        Scanner input = new Scanner(System.in);
        ArrayList<Cards> temp = new ArrayList<Cards>();
        temp=player.getCurrentHand();
        for (Cards c: temp){
            if (c.isAce()&&c.getValue()==0){//Confirms that card is a Ace and user has not already assigned a value
                System.out.println("What value do you want for your Ace");
                int ace = input.nextInt();//todo: limit input options.
                c.setValue(ace);
                player.setCurrentHandValue(pHolder+ace);
            }

        }
    }

    public boolean aceCard(Player dealer){
        boolean play = true;
        int holder =dealer.getCurrentHandValue();
       // System.out.println("ACE METHOD::: CURRENT VALUE OF DEALER" + holder);
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


    //Call this function when dealing an additional card
    public boolean winDrawEval(Player user, Player dealer, boolean play){ //Should be called after first two cards are dealt
        if (dealer.getCurrentHandValue()==21 && user.getCurrentHandValue()== 21){ //Eval if both user and dealer are at 21
            System.out.println("It is a Tie");
            play=false;
            return play;
        }
        else if (dealer.getCurrentHandValue()>21 && user.getCurrentHandValue()>21){
            System.out.println("Dealer Wins");
            play=false;
            return play;
        }
        else if(user.getCurrentHandValue()>21){ //Eval if user over 21
            System.out.println("Dealer Wins");
            play=false;
            return play;
        }
        else if(user.getCurrentHandValue()==21){
            System.out.println("Player wins! Player has 21");
            play = false;
            return play;
        }
        else if (dealer.getCurrentHandValue()==21){
            System.out.println("Dealer wins! Dealer has 21");
            play = false;
            return play;
        }

        return play;
    }

    //Function called to determine a winner when the player decides to stand.
    public boolean playerStandsWinnerFunctions(Player dealer, Player user, boolean play){
        if (dealer.getCurrentHandValue()<=21 && user.getCurrentHandValue()<= dealer.getCurrentHandValue()){
            System.out.println("Dealer Wins");
            play=false;
            return play;
        }
        else if (user.getCurrentHandValue()<=21 && dealer.getCurrentHandValue()<= user.getCurrentHandValue()){
            System.out.println("Players Wins");
            play=false;
            return play;
        }
        else if(dealer.getCurrentHandValue()==user.getCurrentHandValue()){
            System.out.println("It is a Tie");
            play=false;
            return play;
        }
        return play;
    }



}


