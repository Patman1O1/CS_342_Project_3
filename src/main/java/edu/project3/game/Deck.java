package edu.project3.game;

import java.io.Serializable;
import java.util.*;

public class Deck implements Serializable {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final long serialVersionUID = 1L;

    private final List<Card> cards;

    private final Random random;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Deck() {
        this.random = new Random();
        this.cards = new ArrayList<>(52);

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank)); // new unique Card instance
            }
        }
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public void shuffle() { Collections.shuffle(this.cards, this.random); }

    public Card draw() {
        if (this.cards.isEmpty()) {
            throw new NoSuchElementException("Deck is empty");
        }

        return this.cards.remove(this.cards.size() - 1);
    }

    public int size() { return this.cards.size(); }

    public boolean isEmpty() { return this.cards.isEmpty(); }

}
