package me.anthonyvalle.blackJack;


import java.util.Scanner;

public class App
{
    public static void main( String[] args ){

        Player user = new Player(); // the Human Playing the game
        Player dealer = new Player(); // The Computer
        Deck deck = new Deck(); // a deck of cards object
        boolean play = false; // boolean to break Loop

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
        while(play){
            deck.dealTwoCards(dealer);
            deck.dealTwoCards(user);

            System.out.println("Users Cards:");
            user.getCurrentHand();






        }









        //deck.hitMe(dealer);
        ///dealer.getCurrentHand();


    }

}
