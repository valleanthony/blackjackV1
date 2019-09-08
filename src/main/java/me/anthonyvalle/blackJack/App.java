package me.anthonyvalle.blackJack;


import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ){
        Player user = new Player(); // the Human Playing the game
        Player dealer = new Player(); // The Computer
        Deck deck = new Deck(); // a deck of cards object
        Rules rules = new Rules(); //A Class with helper Functions
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
        deck.shuffleDeck(); // Shuffles the cards
        deck.dealTwoCards(user); //User gets two cards
        deck.dealTwoCards(dealer); //Dealer gets two cards

        while(play==true){
            rules.aceCard(user); //User checks cards first as per rule
            rules.aceCard(dealer); //Assigns values to Ace Card for dealer
            rules.showUsersHand(user);//Prints the Users current hand
            play=rules.winDrawEval(user,dealer,play);//checks if the player or dealer is over 21
            if (play==false){
                break;
            }
            if (dealer.getCurrentHandValue()<17){ //if the value is below 17 dealer draws additional card.
                deck.hitMe(dealer); //Card is added to the dealers ArrayList
                rules.aceCard(dealer); //checks if the dealer drew a Ace and determines value based on cards that the dealer holds
                if (dealer.getCurrentHandValue()>21){ //Checks if the dealer went bust by drawing additional card
                    System.out.println("Player wins Dealer went bust");
                    rules.printScore(user,dealer);
                    break; //Ends the loop
                }
            }
            System.out.println("Would you like to draw another card or stand ( type the letter Y = Draw / any other character to = Stand)?");
            response = keyboard.nextLine();

            if (response.equalsIgnoreCase("Y")){ //if user enters 'Y' a card is drawn from the playing deck and handed to player
                deck.hitMe(user); //adds card to the users hand
                rules.aceCard(user); //checks if the card is a Ace and asks the user to input value for the Ace
                rules.showUsersHand(user);
                play=rules.winDrawEval(user,dealer,play); //Checks if the user is over 21 and sends back a boolean
                if (play==false){
                    break;
                }
            }
            else{
                play=rules.playerStandsWinnerFunctions(dealer,user,play);//Evaluates Current scenario to determine a winner.
            }
        }
    }
}
