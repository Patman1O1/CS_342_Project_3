package edu.project3.game;

public enum Rank {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
    QUEEN(12), KING(13), ACE(14);

    public final int value;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    Rank(int value) { this.value = value; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() {
        switch(this) {
            case TWO: return "Two";
            case THREE: return "Three";
            case FOUR: return "Four";
            case FIVE: return "Five";
            case SIX: return "Six";
            case SEVEN: return "Seven";
            case EIGHT: return "Eight";
            case NINE: return "Nine";
            case TEN: return "Ten";
            case JACK: return "Jack";
            case QUEEN: return "Queen";
            case KING: return "King";
            case ACE: return "Ace";
            default: return "";
        }
    }

}
