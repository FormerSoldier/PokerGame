package model;

public class Poker {
    //Spade 黑桃
    //Heart 红桃
    //Diamond 方块
    //Club 梅花
    private char number;
    private char suit;
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
}
