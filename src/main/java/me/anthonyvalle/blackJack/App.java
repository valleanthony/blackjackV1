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
        dealer.setDealer(true);

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


        deck.dealTwoCards(dealer); //Dealer gets two cards
        deck.dealTwoCards(user);
        while(play){
            rules.aceCard(dealer); //Assigns values to Ace Cards, and checks if there is a winner
            deck.sizeOfDeck();
            System.out.println();
            if (dealer.getCurrentHandValue()<17){
                deck.hitMe(dealer);
                deck.sizeOfDeck();
                rules.aceCard(dealer);

            }
            if (dealer.getCurrentHandValue()>21){
                System.out.println("Player Wins");
                play=false;
            }
            if (dealer.getCurrentHandValue()==21){
                System.out.println("Dealer Wins");
                play=false;
            }
            System.out.println("TEST::: PRINTING CURRENT VALUE OF DEALER " + dealer.getCurrentHandValue());
            System.out.println();
            System.out.println();
            rules.checkValue(user);





        }









        //deck.hitMe(dealer);
        ///dealer.getCurrentHand();


    }

}
