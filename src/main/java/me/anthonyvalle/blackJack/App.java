package me.anthonyvalle.blackJack;


import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ){

        Player user = new Player(); // the Human Playing the game
        Player dealer = new Player(); // The Computer
        Deck deck = new Deck(); // a deck of cards object
        Rules rules = new Rules();
        boolean play = false; // boolean to break Loop
        dealer.setDealer(true); // Must set this to true for dealer

        System.out.println("Welcome to Terminal BlackJack");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to play? (Y/N)");
        System.out.println("Enter 'Y' to play");
        String response = keyboard.nextLine();
        if(response.equalsIgnoreCase("y")){
            play=true;
        }else{
            System.out.println("GoodBye!");
        }
        deck.makeDeck();//Outside of the loop so no new deck is made
        deck.shuffleDeck();
        deck.dealTwoCards(user); //User gets two cards
        deck.dealTwoCards(dealer); //Dealer gets two cards

        while(play){
            rules.aceCard(dealer); //Assigns values to Ace Cards, and checks if there is a winner
            //deck.sizeOfDeck();
            //System.out.println();
            rules.checkValue(user); //User checks cards first as per rule;
            System.out.println(user.getCurrentHand().toString());
            if (dealer.getCurrentHandValue()<17){ //if the value is below 17 he draws again.
                deck.hitMe(dealer);
                deck.sizeOfDeck();
                rules.aceCard(dealer);
                if (dealer.getCurrentHandValue()>21){
                    System.out.println("Player wins Dealer went bust");

                    play=false;

                }
            }
            System.out.println("Would you like to draw another card or stand ( type the letter Y = Draw / N = Stand)?");
            response = keyboard.nextLine();
            if (response.equalsIgnoreCase("Y")){
                deck.hitMe(user);
                rules.checkValue(user);
            }else{
                if (dealer.getCurrentHandValue()<=21 && user.getCurrentHandValue()<= dealer.getCurrentHandValue()){
                    System.out.println("Dealer Wins");
                    play=false;
                }
                else if (user.getCurrentHandValue()<=21 && dealer.getCurrentHandValue()<= user.getCurrentHandValue()){
                    System.out.println("Players Wins");
                    play=false;
                }

                else if(dealer.getCurrentHandValue()>21){
                    System.out.println("Player Wins");
                    play=false;
                }
                else if (dealer.getCurrentHandValue()==21 && user.getCurrentHandValue()== 21){
                    System.out.println("Dealer Wins");
                    play=false;
                }



            }




//            System.out.println("TEST::: PRINTING CURRENT VALUE OF DEALER " + dealer.getCurrentHandValue());
//            System.out.println();
//            System.out.println();
            //System.out.println(user.getCurrentHand().toString());






        }









        //deck.hitMe(dealer);
        ///dealer.getCurrentHand();


    }

}
