package me.anthonyvalle.blackJack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
    // All cards are initially stored in an ArrayList. Upon being shuffled they are moved to a stack for the dealer to deal

    private Cards cards;
    private ArrayList<Cards> deck = new ArrayList<Cards>();



    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public Deck() {


    }

    //Methods

    public void makeDeck(){
       int counter = 0;
        for (Suit s: Suit.values()){
            for (Rank r: Rank.values()){
                Cards cards = new Cards();
                cards.setSuit(s);
                cards.setRank(r);
                cards.setAce(false);
                cards.setValue(10);
                if (cards.getRank()==Rank.Two){
                    cards.setValue(2);}
                if (cards.getRank()==Rank.Three){
                    cards.setValue(3);}
                if (cards.getRank()==Rank.Four){
                    cards.setValue(4);}
                if (cards.getRank()==Rank.Five){
                    cards.setValue(5);}
                if (cards.getRank()==Rank.Six){
                    cards.setValue(6);}
                if (cards.getRank()==Rank.Seven){
                    cards.setValue(7);}
                if (cards.getRank()==Rank.Eight){
                    cards.setValue(8);}
                if (cards.getRank()==Rank.Nine){
                    cards.setValue(9);}
                if (cards.getRank()== Rank.Ace){
                    cards.setAce(true);
                    cards.setValue(0);//Will be determined when card is drawn
                }
                deck.add(cards);
                counter++;
            }
        }

        //System.out.println(counter);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);

    }

    public void dealTwoCards(Player player){
        int seed = 0;
        int bound = deck.size()-1; // Goes down as cards are drawn
        ArrayList<Cards> currentHand = new ArrayList<>(); // Sending this back
        Random ran = new Random();

        for (int i = 0; i<2; i++){
            seed = ran.nextInt(bound); // lets the computer generate a random number
            currentHand.add(deck.get(seed)); //sets a card one by one in the new ArrayList
            deck.remove(seed);
            System.out.println(bound);
        }
        player.setCurrentHand(currentHand); //Sets the new ArrayList in the Player as a param. Player now has two cards
        int total=0;
        for (Cards cards:currentHand){ //Evaluates the value of the cards and gives the player a score based on the value of cards
          total= total+cards.getValue();
            //System.out.println("Current Hand: " + cards.toString());
        }
        //System.out.println("current Value of Hand " + total);
        player.setCurrentHandValue(total);
    }

    public void hitMe(Player player){
        System.out.println("Current size of deck: ");
        System.out.println(deck.size()-1);
        Random ran = new Random();
        System.out.println("Ran num"+ran);
        int seed = 0;
        int bound = deck.size()-1;
        seed = ran.nextInt(bound);
        player.getCurrentHand().add(deck.get(seed)); //adds card to players arraylist
        deck.remove(seed);




    }











}
