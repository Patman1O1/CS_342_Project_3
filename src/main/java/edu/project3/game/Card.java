package edu.project3.game;

public abstract class Card {
    /* --------------------------------------------------Suite------------------------------------------------------- */
    public enum Suit { Clubs, Diamonds, Hearts, Spades }

    /* --------------------------------------------------Fields------------------------------------------------------ */
    protected Suit suit;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Card(Suit suit) throws NullPointerException { this.setSuit(suit); }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setSuit(Suit suit) throws NullPointerException {
        if (suit == null) {
            throw new NullPointerException("\"suit\" cannot be null");
        }
        this.suit = suit;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public Suit getSuit() { return this.suit; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object object);

    public abstract int compare(Card card);

}
