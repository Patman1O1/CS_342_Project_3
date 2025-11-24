package edu.project3.game;

import java.io.Serializable;

public class Card implements Serializable, Comparable<Card> {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private final Suit suit;

    private final Rank rank;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Card(Suit suit, Rank rank) throws NullPointerException {
        // Set the suit
        if (suit == null) {
            throw new NullPointerException("\"suit\" cannot be null");
        }
        this.suit = suit;

        // Set the rank
        if (rank == null) {
            throw new NullPointerException("\"rank\" cannot be null");
        }
        this.rank = rank;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public Suit getSuit() { return this.suit; }

    public Rank getRank() { return this.rank; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() { return this.rank + " of " + this.suit; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Card)) {
            return false;
        }

        return ((Card) object).suit == this.suit &&  this.rank == ((Card) object).rank;
    }

    @Override
    public int compareTo(Card other) throws NullPointerException {
        if (other == null) {
            throw new NullPointerException("\"other\" cannot be null");
        }
        return Integer.compare(this.rank.value, other.rank.value);
    }

}
