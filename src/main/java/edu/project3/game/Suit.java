package edu.project3.game;

public enum Suit {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    CLUBS, DIAMONDS, HEARTS, SPADES;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    Suit() {}

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() {
        switch (this) {
            case CLUBS: return "Clubs";
            case DIAMONDS: return "Diamonds";
            case HEARTS: return "Hearts";
            case SPADES: return "Spades";
            default: return "";
        }
    }
}
