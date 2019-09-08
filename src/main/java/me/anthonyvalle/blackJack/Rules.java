package me.anthonyvalle.blackJack;


import java.util.ArrayList;

public class Rules {

    //Helper Functions



    public void aceCard(Player player){
        int holder =player.getCurrentHandValue();
       // System.out.println("ACE METHOD::: CURRENT VALUE OF DEALER" + holder);
            ArrayList<Cards> temp;
            temp=player.getCurrentHand(); // holding current hand
            for (Cards b: temp) {  //Checks each card to see if the dealer holds a Ace
                if (b.isAce() && b.getValue() == 0) { // if the player holds an Ace card the value is assigned based on the value of the other card the dealers holds
                    if (player.getCurrentHandValue() <= 10) { // if the value of the other card is less thn 10 we assign 11 as the value of the ace
                        b.setValue(11);
                        player.setCurrentHandValue(holder + 11);
                    } else if (player.getCurrentHandValue() > 10) { //if the value of two cards is greater then ten then the value of Ace is one
                        b.setValue(1);
                        player.setCurrentHandValue(holder + 1);
                    }
                }
            }

    }


    //Call this function when dealing an additional card
    public boolean winDrawEval(Player user, Player dealer, boolean play){ //Should be called after first two cards are dealt
        if (dealer.getCurrentHandValue()==21 && user.getCurrentHandValue()== 21){ //Eval if both user and dealer are at 21
            System.out.println("It is a Tie");
            printScore(user, dealer);
            play=false;
            return play;
        }
        else if (dealer.getCurrentHandValue()>21 && user.getCurrentHandValue()>21){
            System.out.println("Dealer Wins");
            printScore(user, dealer);
            play=false;
            return play;
        }
        else if(user.getCurrentHandValue()>21){ //Eval if user over 21
            System.out.println("Dealer Wins");
            printScore(user, dealer);
            play=false;
            return play;
        }
        else if(user.getCurrentHandValue()==21){
            System.out.println("Player wins! Player has 21");
            printScore(user, dealer);
            play = false;
            return play;
        }
        else if (dealer.getCurrentHandValue()==21){
            System.out.println("Dealer wins! Dealer has 21");
            printScore(user, dealer);
            play = false;
            return play;
        }

        return play;
    }

    //Function called to determine a winner when the player decides to stand.
    public boolean playerStandsWinnerFunctions(Player dealer, Player user, boolean play){
        if (dealer.getCurrentHandValue()<=21 && user.getCurrentHandValue()<= dealer.getCurrentHandValue()){
            System.out.println("Dealer Wins");
            printScore(user, dealer);
            play=false;
            return play;
        }
        else if (user.getCurrentHandValue()<=21 && dealer.getCurrentHandValue()<= user.getCurrentHandValue()){
            System.out.println("Players Wins");
            printScore(user, dealer);
            play=false;
            return play;
        }
        else if(dealer.getCurrentHandValue()==user.getCurrentHandValue()){
            System.out.println("It is a Tie");
            printScore(user, dealer);
            play=false;
            return play;
        }
        return play;
    }

    public void printScore(Player user,Player dealer){
        System.out.println();
        System.out.println("Dealer's current hand value: "+dealer.getCurrentHandValue() +"\n" +
                "Dealer's Current Hand: "+ dealer.getCurrentHand().toString()+"\n");
        System.out.println();
        System.out.println("User's current hand value: "+user.getCurrentHandValue() +"\n" +
                "Dealer's Current Hand: "+ user.getCurrentHand().toString()+"\n");
        System.out.println();
    }

    public void showUsersHand(Player user){
        System.out.println();
        ArrayList<Cards> holder = user.getCurrentHand();
        int start =1;
        for (Cards c: holder){
            System.out.println("Card Number: " + start);
            System.out.println("----------------------------"+"\n");
            System.out.println("Suit : "+c.getSuit() +" of"+"\n");
            System.out.println("Rank : "+c.getRank() +"\n");
            System.out.println("Value : "+c.getValue() +"\n");
            System.out.println("----------------------------"+"\n");
            start++;
        }
        System.out.println("User's current hand value: "+user.getCurrentHandValue() +"\n");
    }

}


