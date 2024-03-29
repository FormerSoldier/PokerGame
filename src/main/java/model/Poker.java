package model;

public class Poker{
    private char number;
    private char suit;

    public static String dictionary = "23456789TJQKA";
    public Poker(char number, char suit) {
        this.number = number;
        this.suit = suit;
    }

    public Poker() {
    }

    public char getNumber() {
        return number;
    }

    public void setNumber(char number) {
        this.number = number;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return getNumber()+""+getSuit();
    }
}
