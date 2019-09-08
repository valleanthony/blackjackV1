package me.anthonyvalle.blackJack;

public class Cards {

    private Suit suit; //Enum hearts, clubs and so on
    private int value; //Used to calculate the cards value. Ace can be 1 or 11
    private Rank rank; // Enum the number ace to kings
    private boolean isAce;


    public boolean isAce() {
        return isAce;
    }

    public void setAce(boolean ace) {
        isAce = ace;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card:{" +
                "suit=" + suit +
                ", Character=" + rank +
                ", Card Value=" + value +
                ", Ace? =" + isAce +
                '}';
    }
}
